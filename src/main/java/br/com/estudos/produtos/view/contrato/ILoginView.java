/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface ILoginView extends IJanelaView {
    String getIdentificacao();
    String getSenha();
    void aoEntrar(Runnable acao);
    void aoFechar(Runnable acao);
}
