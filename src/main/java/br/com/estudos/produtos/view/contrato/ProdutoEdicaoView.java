package br.com.estudos.produtos.view.contrato;

public interface ProdutoEdicaoView extends JanelaView {
    String getNome();
    String getCusto();
    int getCategoriaIndice();
    void mostrarCategorias(String[] nomes);
    void mostrarDados(String nome, String custo, int categoria, String margem, String venda);
    void aoSalvar(Runnable acao);
    void aoCancelar(Runnable acao);
}

