package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.repositorio.UsuarioRepository;
import java.util.List;

public class UsuarioServico {
    private final UsuarioRepository usuarios;

    public UsuarioServico(UsuarioRepository usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> listar() {
        return usuarios.listar();
    }

    public Usuario obter(int id) {
        return usuarios.buscarPorId(id)
                .orElseThrow(() -> new RegraNegocioException("Usuário não encontrado."));
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
                    usuarios.proximoId(),
                    nomeValido,
                    emailValido,
                    nomeUsuarioValido,
                    senhaValida,
                    perfilValido,
                    habilitado,
                    cliente
            );
        } else {
            usuario = obter(id);
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

        usuarios.salvar(usuario);
        return usuario;
    }

    public void criarAdministradorInicial() {
        if (usuarios.listar().isEmpty()) {
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