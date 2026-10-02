/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.model;

public class Categoria {
    private final int id;
    private String nome;
    private Double percentualLucro;

    public Categoria(int id, String nome, Double percentualLucro) {
        this.id = id;
        atualizar(nome, percentualLucro);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPercentualLucro() {
        return percentualLucro;
    }

    public void atualizar(String nome, Double percentualLucro) {
        this.nome = nome;
        this.percentualLucro = percentualLucro;
    }
}

