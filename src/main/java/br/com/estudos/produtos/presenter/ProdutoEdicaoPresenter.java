package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.servico.CategoriaServico;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.view.contrato.ProdutoEdicaoView;
import java.util.List;

public class ProdutoEdicaoPresenter {
    private final ProdutoEdicaoView view;
    private final ProdutoServico produtos;
    private final List<Categoria> categorias;
    private final Integer id;

    public ProdutoEdicaoPresenter(ProdutoEdicaoView view, ProdutoServico produtos,
            CategoriaServico categorias, Integer id) {
        this.view = view;
        this.produtos = produtos;
        this.categorias = categorias.listar();
        this.id = id;
        view.mostrarCategorias(this.categorias.stream().map(Categoria::getNome).toArray(String[]::new));
        if (id == null) {
            view.mostrarDados("", "", -1, "", "");
        } else {
            Produto p = produtos.obter(id);
            int indice = this.categorias.indexOf(p.getCategoria());
            view.mostrarDados(p.getNome(), Formatos.numero(p.getPrecoCusto()), indice,
                    Formatos.numero(p.getMargemAtual()), Formatos.numero(p.getPrecoVendaAtual()));
        }
        view.aoSalvar(this::salvar);
        view.aoCancelar(view::fechar);
    }

    private void salvar() {
        try {
            int indice = view.getCategoriaIndice();
            Integer categoriaId = indice < 0 || indice >= categorias.size() ? null : categorias.get(indice).getId();
            produtos.salvar(id, view.getNome(), Formatos.lerNumero(view.getCusto(), "o preço de custo"), categoriaId);
            view.fechar();
        } catch (RegraNegocioException e) {
            view.mensagem(e.getMessage());
        }
    }
}

