/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.HistoricoPreco;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.IHistoricoPrecoRepository;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.view.contrato.IHistoricoView;
import java.util.List;

public class HistoricoPresenter {
    public HistoricoPresenter(IHistoricoView view, ProdutoServico produtos, IHistoricoPrecoRepository historicos, int id) {
        Produto produto = produtos.consultar(id);
        view.mostrarProduto(produto.getNome(), produto.getCategoria().getNome());
        List<HistoricoPreco> registros = historicos.listarPorProduto(id);
        String[][] linhas = new String[registros.size()][3];
        for (int i = 0; i < registros.size(); i++) {
            HistoricoPreco h = registros.get(i);
            linhas[i] = new String[] {Formatos.data(h.getData()), Formatos.numero(h.getPercentualLucro()),
                    Formatos.numero(h.getPrecoVenda())};
        }
        view.mostrarHistorico(linhas);
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
    }
}
