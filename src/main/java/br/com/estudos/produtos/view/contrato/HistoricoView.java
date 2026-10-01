package br.com.estudos.produtos.view.contrato;

public interface HistoricoView extends JanelaView {
    void mostrarProduto(String nome, String categoria);
    void mostrarHistorico(String[][] linhas);
    void aoFechar(Runnable acao);
}

