package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    int proximoId();
    void salvar(Categoria categoria);
    void excluir(int id);
    Optional<Categoria> buscarPorId(int id);
    List<Categoria> listar();
}

