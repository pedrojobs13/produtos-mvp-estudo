/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.model;

public class Produto {
    private final int id;
    private String nome;
    private Double precoCusto;
    private Categoria categoria;
    private Double margemAtual;
    private Double precoVendaAtual;

    public Produto(int id, String nome, Double precoCusto, Categoria categoria) {
        this.id = id;
        atualizar(nome, precoCusto, categoria);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Double getMargemAtual() {
        return margemAtual;
    }

    public Double getPrecoVendaAtual() {
        return precoVendaAtual;
    }

    public void atualizar(String nome, Double precoCusto, Categoria categoria) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.categoria = categoria;
    }

    public void atualizarPreco(Double margem, Double precoVenda) {
        this.margemAtual = margem;
        this.precoVendaAtual = precoVenda;
    }
}

