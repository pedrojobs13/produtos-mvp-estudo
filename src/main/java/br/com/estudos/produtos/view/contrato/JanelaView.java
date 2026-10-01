package br.com.estudos.produtos.view.contrato;

public interface JanelaView {
    void exibir();
    void fechar();
    void mensagem(String texto);
    boolean confirmar(String texto);
}

