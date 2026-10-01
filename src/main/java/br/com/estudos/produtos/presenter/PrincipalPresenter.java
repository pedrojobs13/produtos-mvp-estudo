package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.view.contrato.PrincipalView;

public class PrincipalPresenter {
    public PrincipalPresenter(PrincipalView view, Navegacao navegacao) {
        view.aoIncluir(navegacao::incluirProduto);
        view.aoBuscar(navegacao::buscarProdutos);
        view.aoCategorias(navegacao::categorias);
        view.aoCalcular(navegacao::calcular);
    }
}

