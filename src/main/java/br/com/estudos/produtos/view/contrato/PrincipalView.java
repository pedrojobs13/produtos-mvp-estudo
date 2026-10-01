package br.com.estudos.produtos.view.contrato;

public interface PrincipalView extends JanelaView {
    void aoIncluir(Runnable acao);
    void aoBuscar(Runnable acao);
    void aoCategorias(Runnable acao);
    void aoCalcular(Runnable acao);
}

