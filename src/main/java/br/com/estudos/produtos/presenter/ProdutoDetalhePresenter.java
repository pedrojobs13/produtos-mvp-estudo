package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.view.contrato.ProdutoDetalheView;

public class ProdutoDetalhePresenter {
    private final ProdutoDetalheView view;
    private final ProdutoServico produtos;
    private final int id;

    public ProdutoDetalhePresenter(ProdutoDetalheView view, ProdutoServico produtos, Navegacao navegacao, int id) {
        this.view = view;
        this.produtos = produtos;
        this.id = id;
        view.aoEditar(() -> { navegacao.editarProduto(id); atualizar(); });
        view.aoHistorico(() -> navegacao.historicoProduto(id));
        view.aoFechar(view::fechar);
        atualizar();
    }

    private void atualizar() {
        Produto p = produtos.obter(id);
        view.mostrarDados(p.getNome(), Formatos.numero(p.getPrecoCusto()), p.getCategoria().getNome(),
                Formatos.numero(p.getMargemAtual()), Formatos.numero(p.getPrecoVendaAtual()));
    }
}

