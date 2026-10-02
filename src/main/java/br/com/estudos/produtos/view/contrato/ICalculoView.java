/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface ICalculoView extends IJanelaView {
    String getData();
    void mostrarData(String data);
    void mostrarAviso(String texto);
    void mostrarResultados(String[][] linhas);
    void aoCalcular(Runnable acao);
    void aoFechar(Runnable acao);
}

