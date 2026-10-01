package br.com.estudos.produtos.view.contrato;

public interface CategoriasView extends JanelaView {
    String getNome();
    String getPercentual();
    int getLinha();
    void mostrarDados(String nome, String percentual);
    void mostrarCategorias(String[][] linhas);
    void selecionarLinha(int indice);
    void definirModo(boolean editando, boolean selecionado, String descricao);
    void aoNovo(Runnable acao);
    void aoEditar(Runnable acao);
    void aoExcluir(Runnable acao);
    void aoSalvar(Runnable acao);
    void aoCancelar(Runnable acao);
    void aoFechar(Runnable acao);
    void aoSelecionar(Runnable acao);
}

