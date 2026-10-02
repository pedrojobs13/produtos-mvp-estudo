/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.servico.CategoriaServico;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.view.contrato.IProdutoEdicaoView;
import java.util.List;

public class ProdutoEdicaoPresenter {
    private IProdutoEdicaoView view;
    private ProdutoServico produtos;
    private List<Categoria> categorias;
    private Integer id;

    public ProdutoEdicaoPresenter(IProdutoEdicaoView view, ProdutoServico produtos,
            CategoriaServico categorias, Integer id) {
        this.view = view;
        this.produtos = produtos;
        this.categorias = categorias.listar();
        this.id = id;
        String[] nomesCategorias = new String[this.categorias.size()];
        for (int i = 0; i < this.categorias.size(); i++) {
            nomesCategorias[i] = this.categorias.get(i).getNome();
        }
        view.mostrarCategorias(nomesCategorias);
        if (id == null) {
            view.mostrarDados("", "", -1, "", "");
        } else {
            Produto p = produtos.obter(id);
            int indice = this.categorias.indexOf(p.getCategoria());
            view.mostrarDados(p.getNome(), Formatos.numero(p.getPrecoCusto()), indice,
                    Formatos.numero(p.getMargemAtual()), Formatos.numero(p.getPrecoVendaAtual()));
        }
        view.aoSalvar(new Runnable() {
            @Override
            public void run() {
                salvar();
            }
        });
        view.aoCancelar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
    }

    private void salvar() {
        try {
            int indice = view.getCategoriaIndice();
            Integer categoriaId = indice < 0 || indice >= categorias.size() ? null : categorias.get(indice).getId();
            produtos.salvar(id, view.getNome(), Formatos.lerNumero(view.getCusto(), "o preço de custo"), categoriaId);
            view.fechar();
        } catch (RegraNegocioException e) {
            view.mensagem(e.getMessage());
        }
    }
}

