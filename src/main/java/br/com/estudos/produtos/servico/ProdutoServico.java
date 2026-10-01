package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.CategoriaRepository;
import br.com.estudos.produtos.repositorio.ProdutoRepository;
import java.util.List;
import java.util.Locale;

public class ProdutoServico {
    private final ProdutoRepository produtos;
    private final CategoriaRepository categorias;

    public ProdutoServico(ProdutoRepository produtos, CategoriaRepository categorias) {
        this.produtos = produtos;
        this.categorias = categorias;
    }

    public List<Produto> listar() { return produtos.listar(); }

    public Produto obter(int id) {
        return produtos.buscarPorId(id)
                .orElseThrow(() -> new RegraNegocioException("Produto não encontrado."));
    }

    public Produto salvar(Integer id, String nome, Double custo, Integer categoriaId) {
        String nomeValido = Validacao.nome(nome, "Nome do produto");
        Validacao.numero(custo, "Preço de custo", false);
        if (categoriaId == null) {
            throw new RegraNegocioException("Selecione uma categoria.");
        }
        Categoria categoria = categorias.buscarPorId(categoriaId)
                .orElseThrow(() -> new RegraNegocioException("A categoria informada não existe."));
        Produto produto;
        if (id == null) {
            produto = new Produto(produtos.proximoId(), nomeValido, custo, categoria);
        } else {
            produto = obter(id);
            produto.atualizar(nomeValido, custo, categoria);
        }
        produtos.salvar(produto);
        return produto;
    }

    public List<Produto> buscar(String texto, boolean porCategoria) {
        String termo = texto == null ? "" : texto.trim().toLowerCase(Locale.ROOT);
        return produtos.listar().stream().filter(p -> {
            String campo = porCategoria ? p.getCategoria().getNome() : p.getNome();
            return campo.toLowerCase(Locale.ROOT).contains(termo);
        }).toList();
    }
}

