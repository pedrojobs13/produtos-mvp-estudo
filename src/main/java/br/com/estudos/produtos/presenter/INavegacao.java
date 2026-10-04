/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

public interface INavegacao {
    void incluirProduto();
    void buscarProdutos();
    void categorias();
    void clientes();
    void usuarios();
    void calcular();
    void visualizarProduto(int id);
    void editarProduto(int id);
    void historicoProduto(int id);
    void sair();
}

