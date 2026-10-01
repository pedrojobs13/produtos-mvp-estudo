package br.com.estudos.produtos.view.contrato;

public interface CalculoView extends JanelaView {
    String getData();
    void mostrarData(String data);
    void mostrarAviso(String texto);
    void mostrarResultados(String[][] linhas);
    void aoCalcular(Runnable acao);
    void aoFechar(Runnable acao);
}

