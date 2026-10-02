/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.ICategoriaRepository;
import br.com.estudos.produtos.repositorio.IProdutoRepository;
import java.util.List;

public class CategoriaServico {
    private ICategoriaRepository categoriaRepository;
    private IProdutoRepository produtoRepository;

    public CategoriaServico(ICategoriaRepository categoriaRepository, IProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.listarTodos();
    }

    public Categoria consultar(int id) {
        Categoria categoria = categoriaRepository.consultar(id);
        if (categoria == null) {
            throw new RegraNegocioException("Categoria não encontrada.");
        }
        return categoria;
    }

    public Categoria salvar(Integer id, String nome, Double percentual) {
        String nomeValido = Validacao.nome(nome, "Nome da categoria");
        Validacao.numero(percentual, "Percentual de lucro", true);
        for (Categoria existente : categoriaRepository.listarTodos()) {
            if (existente.getNome().equalsIgnoreCase(nomeValido)
                    && (id == null || existente.getId() != id)) {
                throw new RegraNegocioException("Já existe uma categoria com esse nome.");
            }
        }
        Categoria categoria;
        if (id == null) {
            categoria = new Categoria(categoriaRepository.proximoId(), nomeValido, percentual);
        } else {
            categoria = consultar(id);
            categoria.atualizar(nomeValido, percentual);
        }
        categoriaRepository.salvar(categoria);
        return categoria;
    }

    public void excluir(int id) {
        consultar(id);
        boolean possuiProdutos = false;
        for (Produto produto : produtoRepository.listarTodos()) {
            if (produto.getCategoria().getId() == id) {
                possuiProdutos = true;
            }
        }
        if (possuiProdutos) {
            throw new RegraNegocioException("A categoria não pode ser excluída: existem produtos associados.");
        }
        categoriaRepository.excluir(id);
    }
}
