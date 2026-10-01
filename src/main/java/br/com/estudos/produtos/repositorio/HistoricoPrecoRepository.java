package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.HistoricoPreco;
import java.util.List;

public interface HistoricoPrecoRepository {
    void salvarTodos(List<HistoricoPreco> registros);
    List<HistoricoPreco> listarPorProduto(int produtoId);
}

