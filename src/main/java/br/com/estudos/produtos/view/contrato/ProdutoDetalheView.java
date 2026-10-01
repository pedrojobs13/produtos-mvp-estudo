package br.com.estudos.produtos.view.contrato;

public interface ProdutoDetalheView extends JanelaView {
    void mostrarDados(String nome, String custo, String categoria, String margem, String venda);
    void aoEditar(Runnable acao);
    void aoHistorico(Runnable acao);
    void aoFechar(Runnable acao);
}

