package br.com.estudos.produtos.view.contrato;

public interface BuscaView extends JanelaView {
    String getTexto();
    boolean isBuscaCategoria();
    int getLinha();
    void mostrarProdutos(String[][] linhas);
    void habilitarVisualizar(boolean habilitado);
    void aoBuscar(Runnable acao);
    void aoNovo(Runnable acao);
    void aoVisualizar(Runnable acao);
    void aoSelecionar(Runnable acao);
    void aoFechar(Runnable acao);
}

