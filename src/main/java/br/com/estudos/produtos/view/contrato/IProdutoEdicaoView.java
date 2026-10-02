/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IProdutoEdicaoView extends IJanelaView {
    String getNome();
    String getCusto();
    int getCategoriaIndice();
    void mostrarCategorias(String[] nomes);
    void mostrarDados(String nome, String custo, int categoria, String margem, String venda);
    void aoSalvar(Runnable acao);
    void aoCancelar(Runnable acao);
}

