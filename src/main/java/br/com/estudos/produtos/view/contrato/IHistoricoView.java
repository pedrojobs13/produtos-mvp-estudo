/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IHistoricoView extends IJanelaView {
    void mostrarProduto(String nome, String categoria);
    void mostrarHistorico(String[][] linhas);
    void aoFechar(Runnable acao);
}

