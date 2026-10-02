/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos;

import br.com.estudos.produtos.presenter.BuscaPresenter;
import br.com.estudos.produtos.presenter.CalculoPresenter;
import br.com.estudos.produtos.presenter.CategoriasPresenter;
import br.com.estudos.produtos.presenter.HistoricoPresenter;
import br.com.estudos.produtos.presenter.INavegacao;
import br.com.estudos.produtos.presenter.ILoginNavegacao;
import br.com.estudos.produtos.presenter.LoginPresenter;
import br.com.estudos.produtos.presenter.PrincipalPresenter;
import br.com.estudos.produtos.presenter.ProdutoDetalhePresenter;
import br.com.estudos.produtos.presenter.ProdutoEdicaoPresenter;
import br.com.estudos.produtos.repositorio.ICategoriaRepository;
import br.com.estudos.produtos.repositorio.IHistoricoPrecoRepository;
import br.com.estudos.produtos.repositorio.IProdutoRepository;
import br.com.estudos.produtos.repositorio.IUsuarioRepository;
import br.com.estudos.produtos.repositorio.memoria.CategoriaRepositoryMemoria;
import br.com.estudos.produtos.repositorio.memoria.HistoricoPrecoRepositoryMemoria;
import br.com.estudos.produtos.repositorio.memoria.ProdutoRepositoryMemoria;
import br.com.estudos.produtos.repositorio.memoria.UsuarioRepositoryMemoria;
import br.com.estudos.produtos.seeder.Seeder;
import br.com.estudos.produtos.servico.CalculoPrecoServico;
import br.com.estudos.produtos.servico.AutenticacaoServico;
import br.com.estudos.produtos.servico.CategoriaServico;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.servico.UsuarioServico;
import br.com.estudos.produtos.view.BuscaDialog;
import br.com.estudos.produtos.view.CalculoDialog;
import br.com.estudos.produtos.view.CategoriasDialog;
import br.com.estudos.produtos.view.HistoricoDialog;
import br.com.estudos.produtos.view.LoginFrame;
import br.com.estudos.produtos.view.PrincipalFrame;
import br.com.estudos.produtos.view.ProdutoDetalheDialog;
import br.com.estudos.produtos.view.ProdutoEdicaoDialog;

public class Aplicacao implements INavegacao, ILoginNavegacao {
    private final ICategoriaRepository categorias = new CategoriaRepositoryMemoria();
    private final IProdutoRepository produtos = new ProdutoRepositoryMemoria();
    private final IHistoricoPrecoRepository historicos = new HistoricoPrecoRepositoryMemoria();
    private final CategoriaServico categoriaServico = new CategoriaServico(categorias, produtos);
    private final ProdutoServico produtoServico = new ProdutoServico(produtos, categorias);
    private final CalculoPrecoServico calculoServico = new CalculoPrecoServico(produtos, historicos);
    private final IUsuarioRepository usuarios = new UsuarioRepositoryMemoria();
    private final UsuarioServico usuarioServico = new UsuarioServico(usuarios);
    private final AutenticacaoServico autenticacaoServico = new AutenticacaoServico(usuarios);

    public void iniciar() {
        new Seeder(categoriaServico, produtoServico, calculoServico, usuarioServico).executar();
        LoginFrame view = new LoginFrame();
        new LoginPresenter(view, autenticacaoServico, this);
        view.exibir();
    }

    @Override
    public void abrirPrincipal(br.com.estudos.produtos.model.Usuario usuario) {
        PrincipalFrame view = new PrincipalFrame();
        new PrincipalPresenter(view, this);
        view.exibir();
    }


    @Override
    public void incluirProduto() {
        ProdutoEdicaoDialog view = new ProdutoEdicaoDialog();
        new ProdutoEdicaoPresenter(view, produtoServico, categoriaServico, null);
        view.exibir();
    }


    @Override
    public void buscarProdutos() {
        BuscaDialog view = new BuscaDialog();
        new BuscaPresenter(view, produtoServico, this);
        view.exibir();
    }


    @Override
    public void categorias() {
        CategoriasDialog view = new CategoriasDialog();
        new CategoriasPresenter(view, categoriaServico);
        view.exibir();
    }


    @Override
    public void calcular() {
        CalculoDialog view = new CalculoDialog();
        new CalculoPresenter(view, calculoServico);
        view.exibir();
    }


    @Override
    public void visualizarProduto(int id) {
        ProdutoDetalheDialog view = new ProdutoDetalheDialog();
        new ProdutoDetalhePresenter(view, produtoServico, this, id);
        view.exibir();
    }


    @Override
    public void editarProduto(int id) {
        ProdutoEdicaoDialog view = new ProdutoEdicaoDialog();
        new ProdutoEdicaoPresenter(view, produtoServico, categoriaServico, id);
        view.exibir();
    }


    @Override
    public void historicoProduto(int id) {
        HistoricoDialog view = new HistoricoDialog();
        new HistoricoPresenter(view, produtoServico, historicos, id);
        view.exibir();
    }
}
