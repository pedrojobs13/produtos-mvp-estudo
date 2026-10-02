/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.model;

public class Cliente {
    public static final String BRONZE = "BRONZE";
    public static final String PRATA = "PRATA";
    public static final String OURO = "OURO";
    public static final String DIAMANTE = "DIAMANTE";

    private final int id;
    private String nome;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String tipo;
    private Double totalCompras;

    public Cliente(int id, String nome, String logradouro, String bairro,
            String cidade, String uf) {
        this.id = id;
        atualizar(nome, logradouro, bairro, cidade, uf);
        this.tipo = PRATA;
        this.totalCompras = 0.0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getTotalCompras() {
        return totalCompras;
    }

    public void atualizar(String nome, String logradouro, String bairro,
            String cidade, String uf) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
}