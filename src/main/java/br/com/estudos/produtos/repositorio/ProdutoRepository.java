package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Produto;
import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    int proximoId();
    void salvar(Produto produto);
    Optional<Produto> buscarPorId(int id);
    List<Produto> listar();
}

