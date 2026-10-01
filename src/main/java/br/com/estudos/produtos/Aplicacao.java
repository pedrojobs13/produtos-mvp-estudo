package br.com.estudos.produtos;

import br.com.estudos.produtos.presenter.*;
import br.com.estudos.produtos.repositorio.*;
import br.com.estudos.produtos.repositorio.memoria.*;
import br.com.estudos.produtos.seeder.Seeder;
import br.com.estudos.produtos.servico.*;
import br.com.estudos.produtos.view.*;


public class Aplicacao implements Navegacao {
    private final CategoriaRepository categorias = new CategoriaRepositoryMemoria();
    private final ProdutoRepository produtos = new ProdutoRepositoryMemoria();
    private final HistoricoPrecoRepository historicos = new HistoricoPrecoRepositoryMemoria();
    private final CategoriaServico categoriaServico = new CategoriaServico(categorias, produtos);
    private final ProdutoServico produtoServico = new ProdutoServico(produtos, categorias);
    private final CalculoPrecoServico calculoServico = new CalculoPrecoServico(produtos, historicos);
    private final UsuarioRepository usuarios = new UsuarioRepositoryMemoria();
    private final UsuarioServico usuarioServico = new UsuarioServico(usuarios);

    public void iniciar() {
        new Seeder(categoriaServico, produtoServico, calculoServico, usuarioServico).executar();
        PrincipalFrame view = new PrincipalFrame();
        new PrincipalPresenter(view, this);
        view.exibir();
    }

    @Override public void incluirProduto() {
        ProdutoEdicaoDialog view = new ProdutoEdicaoDialog();
        new ProdutoEdicaoPresenter(view, produtoServico, categoriaServico, null);
        view.exibir();
    }

    @Override public void buscarProdutos() {
        BuscaDialog view = new BuscaDialog();
        new BuscaPresenter(view, produtoServico, this);
        view.exibir();
    }

    @Override public void categorias() {
        CategoriasDialog view = new CategoriasDialog();
        new CategoriasPresenter(view, categoriaServico);
        view.exibir();
    }

    @Override public void calcular() {
        CalculoDialog view = new CalculoDialog();
        new CalculoPresenter(view, calculoServico);
        view.exibir();
    }

    @Override public void visualizarProduto(int id) {
        ProdutoDetalheDialog view = new ProdutoDetalheDialog();
        new ProdutoDetalhePresenter(view, produtoServico, this, id);
        view.exibir();
    }

    @Override public void editarProduto(int id) {
        ProdutoEdicaoDialog view = new ProdutoEdicaoDialog();
        new ProdutoEdicaoPresenter(view, produtoServico, categoriaServico, id);
        view.exibir();
    }

    @Override public void historicoProduto(int id) {
        HistoricoDialog view = new HistoricoDialog();
        new HistoricoPresenter(view, produtoServico, historicos, id);
        view.exibir();
    }
}
