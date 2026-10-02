/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface ICategoriasView extends IJanelaView {
    String getNome();
    String getPercentual();
    int getLinha();
    void mostrarDados(String nome, String percentual);
    void mostrarCategorias(String[][] linhas);
    void selecionarLinha(int indice);
    void definirModo(boolean editando, boolean selecionado, String descricao);
    void aoNovo(Runnable acao);
    void aoEditar(Runnable acao);
    void aoExcluir(Runnable acao);
    void aoSalvar(Runnable acao);
    void aoCancelar(Runnable acao);
    void aoFechar(Runnable acao);
    void aoSelecionar(Runnable acao);
}

