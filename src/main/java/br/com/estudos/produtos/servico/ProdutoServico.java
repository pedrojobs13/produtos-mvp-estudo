/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.ICategoriaRepository;
import br.com.estudos.produtos.repositorio.IProdutoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProdutoServico {
    private IProdutoRepository produtoRepository;
    private ICategoriaRepository categoriaRepository;

    public ProdutoServico(IProdutoRepository produtoRepository, ICategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.listarTodos();
    }

    public Produto consultar(int id) {
        Produto produto = produtoRepository.consultar(id);
        if (produto == null) {
            throw new RegraNegocioException("Produto não encontrado.");
        }
        return produto;
    }

    public Produto salvar(Integer id, String nome, Double custo, Integer categoriaId) {
        String nomeValido = Validacao.nome(nome, "Nome do produto");
        Validacao.numero(custo, "Preço de custo", false);
        if (categoriaId == null) {
            throw new RegraNegocioException("Selecione uma categoria.");
        }
        Categoria categoria = categoriaRepository.consultar(categoriaId);
        if (categoria == null) {
            throw new RegraNegocioException("A categoria informada não existe.");
        }
        Produto produto;
        if (id == null) {
            produto = new Produto(produtoRepository.proximoId(), nomeValido, custo, categoria);
        } else {
            produto = consultar(id);
            produto.atualizar(nomeValido, custo, categoria);
        }
        produtoRepository.salvar(produto);
        return produto;
    }

    public List<Produto> buscar(String texto, boolean porCategoria) {
        String termo = texto == null ? "" : texto.trim().toLowerCase(Locale.ROOT);
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtoRepository.listarTodos()) {
            String campo;
            if (porCategoria) {
                campo = produto.getCategoria().getNome();
            } else {
                campo = produto.getNome();
            }
            if (campo.toLowerCase(Locale.ROOT).contains(termo)) {
                encontrados.add(produto);
            }
        }
        return encontrados;
    }
}
