package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.HistoricoPreco;
import br.com.estudos.produtos.repositorio.HistoricoPrecoRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HistoricoPrecoRepositoryMemoria implements HistoricoPrecoRepository {
    private final List<HistoricoPreco> dados = new ArrayList<>();

    public void salvarTodos(List<HistoricoPreco> registros) { dados.addAll(registros); }

    public List<HistoricoPreco> listarPorProduto(int produtoId) {
        return dados.stream()
                .filter(h -> h.getProdutoId() == produtoId)
                .sorted(Comparator.comparing(HistoricoPreco::getData).reversed())
                .toList();
    }
}

