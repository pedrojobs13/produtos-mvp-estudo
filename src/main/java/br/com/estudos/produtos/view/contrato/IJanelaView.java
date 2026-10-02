/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IJanelaView {
    void exibir();
    void fechar();
    void mensagem(String texto);
    boolean confirmar(String texto);
}

