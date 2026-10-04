/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.repositorio.IUsuarioRepository;
import java.util.List;

public class UsuarioServico {
    private IUsuarioRepository usuarioRepository;

    public UsuarioServico(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public Usuario consultar(int id) {
        Usuario usuario = usuarioRepository.consultar(id);
        if (usuario == null) {
            throw new RegraNegocioException("Usuário não encontrado.");
        }
        return usuario;
    }

    public Usuario salvar(Usuario administrador, Integer id, String nome, String email,
            String nomeUsuario, String senha, String perfil, Cliente cliente) {
        validarAdministrador(administrador);

        String nomeValido = Validacao.nome(nome, "Nome");
        String emailValido = Validacao.nome(email, "E-mail");
        String nomeUsuarioValido = Validacao.nome(nomeUsuario, "Nome de usuário");
        String perfilValido = Validacao.nome(perfil, "Perfil").toUpperCase();
        validarPerfil(perfilValido, cliente);
        validarNomeUsuario(id, nomeUsuarioValido);

        Usuario usuario;

        if (id == null) {
            if (Usuario.ADMINISTRADOR.equals(perfilValido)) {
                throw new RegraNegocioException("Não é permitido incluir outro Administrador.");
            }

            String senhaValida = Validacao.nome(senha, "Senha");
            usuario = new Usuario(
                    usuarioRepository.proximoId(),
                    nomeValido,
                    emailValido,
                    nomeUsuarioValido,
                    senhaValida,
                    perfilValido,
                    true,
                    cliente
            );
        } else {
            usuario = consultar(id);
            if (Usuario.ADMINISTRADOR.equals(usuario.getPerfil())) {
                throw new RegraNegocioException("O Administrador não pode ser alterado.");
            }
            if (Usuario.ADMINISTRADOR.equals(perfilValido)) {
                throw new RegraNegocioException("Não é permitido alterar um usuário para Administrador.");
            }

            String senhaValida = senha == null || senha.trim().isEmpty()
                    ? usuario.getSenha() : Validacao.nome(senha, "Senha");

            usuario.atualizar(
                    nomeValido,
                    emailValido,
                    nomeUsuarioValido,
                    senhaValida,
                    perfilValido,
                    cliente
            );
        }

        usuarioRepository.salvar(usuario);
        return usuario;
    }

    public void alterarStatus(Usuario administrador, int id, boolean habilitado) {
        validarAdministrador(administrador);
        Usuario usuario = consultar(id);

        if (Usuario.ADMINISTRADOR.equals(usuario.getPerfil())) {
            throw new RegraNegocioException("O Administrador não pode ser habilitado ou desabilitado.");
        }

        usuario.alterarStatus(habilitado);
        usuarioRepository.salvar(usuario);
    }

    public void excluir(Usuario administrador, int id) {
        validarAdministrador(administrador);
        Usuario usuario = consultar(id);

        if (Usuario.ADMINISTRADOR.equals(usuario.getPerfil())) {
            throw new RegraNegocioException("O Administrador não pode ser excluído.");
        }

        usuarioRepository.excluir(id);
    }

    public void criarAdministradorInicial() {
        if (usuarioRepository.listarTodos().isEmpty()) {
            Usuario administrador = new Usuario(
                    usuarioRepository.proximoId(),
                    "Administrador",
                    "admin@produtos.com",
                    "admin",
                    "123",
                    Usuario.ADMINISTRADOR,
                    true,
                    null
            );
            usuarioRepository.salvar(administrador);
        }
    }

    private void validarAdministrador(Usuario administrador) {
        if (administrador == null || !Usuario.ADMINISTRADOR.equals(administrador.getPerfil())) {
            throw new RegraNegocioException("Somente o Administrador pode manter usuários.");
        }
    }

    private void validarPerfil(String perfil, Cliente cliente) {
        if (!Usuario.ADMINISTRADOR.equals(perfil)
                && !Usuario.ATENDENTE.equals(perfil)
                && !Usuario.CLIENTE.equals(perfil)) {
            throw new RegraNegocioException("Perfil inválido.");
        }

        if (Usuario.CLIENTE.equals(perfil) && cliente == null) {
            throw new RegraNegocioException("Selecione um cliente para o usuário Cliente.");
        }

        if (!Usuario.CLIENTE.equals(perfil) && cliente != null) {
            throw new RegraNegocioException("Somente o perfil Cliente pode possuir cliente associado.");
        }
    }

    private void validarNomeUsuario(Integer id, String nomeUsuario) {
        for (Usuario usuario : usuarioRepository.listarTodos()) {
            boolean outroUsuario = id == null || usuario.getId() != id;
            if (outroUsuario && usuario.getNomeUsuario().equalsIgnoreCase(nomeUsuario)) {
                throw new RegraNegocioException("Nome de usuário já utilizado.");
            }
        }
    }
}
