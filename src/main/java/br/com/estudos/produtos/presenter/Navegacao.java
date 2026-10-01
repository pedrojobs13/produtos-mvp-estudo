package br.com.estudos.produtos.presenter;

public interface Navegacao {
    void incluirProduto();
    void buscarProdutos();
    void categorias();
    void calcular();
    void visualizarProduto(int id);
    void editarProduto(int id);
    void historicoProduto(int id);
}

