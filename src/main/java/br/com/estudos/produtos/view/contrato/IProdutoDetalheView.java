/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IProdutoDetalheView extends IJanelaView {
    void mostrarDados(String nome, String custo, String categoria, String margem, String venda);
    void aoEditar(Runnable acao);
    void aoHistorico(Runnable acao);
    void aoFechar(Runnable acao);
}

