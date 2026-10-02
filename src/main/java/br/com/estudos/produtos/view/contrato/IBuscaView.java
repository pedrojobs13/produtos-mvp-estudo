/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IBuscaView extends IJanelaView {
    String getTexto();
    boolean isBuscaCategoria();
    int getLinha();
    void mostrarProdutos(String[][] linhas);
    void habilitarVisualizar(boolean habilitado);
    void aoBuscar(Runnable acao);
    void aoNovo(Runnable acao);
    void aoVisualizar(Runnable acao);
    void aoSelecionar(Runnable acao);
    void aoFechar(Runnable acao);
}

