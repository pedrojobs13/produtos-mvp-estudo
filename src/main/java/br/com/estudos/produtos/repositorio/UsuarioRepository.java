package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    int proximoId();

    void salvar(Usuario usuario);

    void excluir(int id);

    Optional<Usuario> buscarPorId(int id);

    List<Usuario> listar();
}