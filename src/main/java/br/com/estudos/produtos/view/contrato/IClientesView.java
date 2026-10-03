/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IClientesView extends IJanelaView {
    int getLinha();
    void mostrarDados(String nome, String logradouro, String bairro,
            String cidade, String uf, String tipo, String totalCompras);
    void mostrarClientes(String[][] linhas);
    void selecionarLinha(int indice);
    void aoSelecionar(Runnable acao);
    void aoFechar(Runnable acao);
}
