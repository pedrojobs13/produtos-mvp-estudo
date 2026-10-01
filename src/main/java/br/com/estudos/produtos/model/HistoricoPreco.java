package br.com.estudos.produtos.model;

import java.time.LocalDate;

public final class HistoricoPreco {
    private final int produtoId;
    private final LocalDate data;
    private final Double percentualLucro;
    private final Double precoVenda;

    public HistoricoPreco(int produtoId, LocalDate data, Double percentualLucro, Double precoVenda) {
        this.produtoId = produtoId;
        this.data = data;
        this.percentualLucro = percentualLucro;
        this.precoVenda = precoVenda;
    }

    public int getProdutoId() { return produtoId; }
    public LocalDate getData() { return data; }
    public Double getPercentualLucro() { return percentualLucro; }
    public Double getPrecoVenda() { return precoVenda; }
}

