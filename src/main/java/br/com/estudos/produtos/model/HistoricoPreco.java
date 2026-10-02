/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.model;

import java.time.LocalDate;

public class HistoricoPreco {
    private int produtoId;
    private LocalDate data;
    private Double percentualLucro;
    private Double precoVenda;

    public HistoricoPreco(int produtoId, LocalDate data, Double percentualLucro, Double precoVenda) {
        this.produtoId = produtoId;
        this.data = data;
        this.percentualLucro = percentualLucro;
        this.precoVenda = precoVenda;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getPercentualLucro() {
        return percentualLucro;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }
}

