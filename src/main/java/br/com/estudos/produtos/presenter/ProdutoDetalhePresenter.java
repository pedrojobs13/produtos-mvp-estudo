/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.view.contrato.IProdutoDetalheView;

public class ProdutoDetalhePresenter {
    private final IProdutoDetalheView view;
    private final ProdutoServico produtos;
    private final int id;

    public ProdutoDetalhePresenter(IProdutoDetalheView view, ProdutoServico produtos, INavegacao navegacao, int id) {
        this.view = view;
        this.produtos = produtos;
        this.id = id;
        view.aoEditar(new Runnable() {
            @Override
            public void run() {
                navegacao.editarProduto(id);
                atualizar();
            }
        });
        view.aoHistorico(new Runnable() {
            @Override
            public void run() {
                navegacao.historicoProduto(id);
            }
        });
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
        atualizar();
    }

    private void atualizar() {
        Produto p = produtos.obter(id);
        view.mostrarDados(p.getNome(), Formatos.numero(p.getPrecoCusto()), p.getCategoria().getNome(),
                Formatos.numero(p.getMargemAtual()), Formatos.numero(p.getPrecoVendaAtual()));
    }
}

