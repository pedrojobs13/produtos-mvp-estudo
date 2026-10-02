/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.view.contrato.IPrincipalView;

public class PrincipalPresenter {
    public PrincipalPresenter(IPrincipalView view, INavegacao navegacao) {
        view.aoIncluir(new Runnable() {
            @Override
            public void run() {
                navegacao.incluirProduto();
            }
        });
        view.aoBuscar(new Runnable() {
            @Override
            public void run() {
                navegacao.buscarProdutos();
            }
        });
        view.aoCategorias(new Runnable() {
            @Override
            public void run() {
                navegacao.categorias();
            }
        });
        view.aoCalcular(new Runnable() {
            @Override
            public void run() {
                navegacao.calcular();
            }
        });
    }
}

