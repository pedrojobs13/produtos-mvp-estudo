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

    public Usuario salvar(Integer id, String nome, String email,
            String nomeUsuario, String senha, String perfil,
            boolean habilitado, Cliente cliente) {
        String nomeValido = Validacao.nome(nome, "Nome");
        String emailValido = Validacao.nome(email, "E-mail");
        String nomeUsuarioValido = Validacao.nome(nomeUsuario, "Nome de usuário");
        String senhaValida = Validacao.nome(senha, "Senha");
        String perfilValido = Validacao.nome(perfil, "Perfil");

        Usuario usuario;

        if (id == null) {
            usuario = new Usuario(
                    usuarioRepository.proximoId(),
                    nomeValido,
                    emailValido,
                    nomeUsuarioValido,
                    senhaValida,
                    perfilValido,
                    habilitado,
                    cliente
            );
        } else {
            usuario = consultar(id);
            usuario.atualizar(
                    nomeValido,
                    emailValido,
                    nomeUsuarioValido,
                    senhaValida,
                    perfilValido,
                    cliente
            );
            usuario.alterarStatus(habilitado);
        }

        usuarioRepository.salvar(usuario);
        return usuario;
    }

    public void criarAdministradorInicial() {
        if (usuarioRepository.listarTodos().isEmpty()) {
            salvar(
                    null,
                    "Administrador",
                    "admin@produtos.com",
                    "admin",
                    "123",
                    Usuario.ADMINISTRADOR,
                    true,
                    null
            );
        }
    }
}
