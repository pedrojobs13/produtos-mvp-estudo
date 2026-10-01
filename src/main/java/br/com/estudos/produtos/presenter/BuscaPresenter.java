package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.view.contrato.BuscaView;
import java.util.List;

public class BuscaPresenter {
    private final BuscaView view;
    private final ProdutoServico produtos;
    private List<Produto> resultados = List.of();

    public BuscaPresenter(BuscaView view, ProdutoServico produtos, Navegacao navegacao) {
        this.view = view;
        this.produtos = produtos;
        view.aoBuscar(this::buscar);
        view.aoSelecionar(() -> view.habilitarVisualizar(view.getLinha() >= 0));
        view.aoNovo(() -> { navegacao.incluirProduto(); buscar(); });
        view.aoVisualizar(() -> {
            int linha = view.getLinha();
            if (linha >= 0 && linha < resultados.size()) {
                navegacao.visualizarProduto(resultados.get(linha).getId());
                buscar();
            }
        });
        view.aoFechar(view::fechar);
        buscar();
    }

    private void buscar() {
        resultados = produtos.buscar(view.getTexto(), view.isBuscaCategoria());
        view.mostrarProdutos(Formatos.produtos(resultados));
        view.habilitarVisualizar(false);
    }
}

