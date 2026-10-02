/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.view.contrato.IBuscaView;
import java.util.ArrayList;
import java.util.List;

public class BuscaPresenter {
    private final IBuscaView view;
    private final ProdutoServico service;
    private List<Produto> resultados = new ArrayList<>();

    public BuscaPresenter(IBuscaView view, ProdutoServico service, INavegacao navegacao) {
        this.view = view;
        this.service = service;
        view.aoBuscar(new Runnable() {
            @Override
            public void run() {
                buscar();
            }
        });
        view.aoSelecionar(new Runnable() {
            @Override
            public void run() {
                view.habilitarVisualizar(view.getLinha() >= 0);
            }
        });
        view.aoNovo(new Runnable() {
            @Override
            public void run() {
                navegacao.incluirProduto();
                buscar();
            }
        });
        view.aoVisualizar(new Runnable() {
            @Override
            public void run() {
                int linha = view.getLinha();
                if (linha >= 0 && linha < resultados.size()) {
                    navegacao.visualizarProduto(resultados.get(linha).getId());
                    buscar();
                }
            }
        });
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
        buscar();
    }

    private void buscar() {
        resultados = service.buscar(view.getTexto(), view.isBuscaCategoria());
        view.mostrarProdutos(Formatos.produtos(resultados));
        view.habilitarVisualizar(false);
    }
}
