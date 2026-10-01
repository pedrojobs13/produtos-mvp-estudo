package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.repositorio.CategoriaRepository;
import br.com.estudos.produtos.repositorio.ProdutoRepository;
import java.util.List;

public class CategoriaServico {
    private final CategoriaRepository categorias;
    private final ProdutoRepository produtos;

    public CategoriaServico(CategoriaRepository categorias, ProdutoRepository produtos) {
        this.categorias = categorias;
        this.produtos = produtos;
    }

    public List<Categoria> listar() { return categorias.listar(); }

    public Categoria obter(int id) {
        return categorias.buscarPorId(id)
                .orElseThrow(() -> new RegraNegocioException("Categoria não encontrada."));
    }

    public Categoria salvar(Integer id, String nome, Double percentual) {
        String nomeValido = Validacao.nome(nome, "Nome da categoria");
        Validacao.numero(percentual, "Percentual de lucro", true);
        for (Categoria existente : categorias.listar()) {
            if (existente.getNome().equalsIgnoreCase(nomeValido)
                    && (id == null || existente.getId() != id)) {
                throw new RegraNegocioException("Já existe uma categoria com esse nome.");
            }
        }
        Categoria categoria;
        if (id == null) {
            categoria = new Categoria(categorias.proximoId(), nomeValido, percentual);
        } else {
            categoria = obter(id);
            categoria.atualizar(nomeValido, percentual);
        }
        categorias.salvar(categoria);
        return categoria;
    }

    public void excluir(int id) {
        obter(id);
        boolean possuiProdutos = produtos.listar().stream()
                .anyMatch(p -> p.getCategoria().getId() == id);
        if (possuiProdutos) {
            throw new RegraNegocioException("A categoria não pode ser excluída: existem produtos associados.");
        }
        categorias.excluir(id);
    }
}

