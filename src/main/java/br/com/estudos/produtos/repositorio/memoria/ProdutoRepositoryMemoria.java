/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.IProdutoRepository;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryMemoria implements IProdutoRepository {
    private List<Produto> dados = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public int proximoId() {
        return proximoId++;
    }


    @Override
    public void salvar(Produto produto) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == produto.getId()) {
                dados.set(i, produto);
                return;
            }
        }
        dados.add(produto);
    }


    @Override
    public Produto buscarPorId(int id) {
        for (Produto produto : dados) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }


    @Override
    public List<Produto> listar() {
        return new ArrayList<>(dados);
    }
}
