/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Produto;
import java.util.List;

public interface IProdutoRepository {
    int proximoId();
    void salvar(Produto produto);
    Produto buscarPorId(int id);
    List<Produto> listar();
}

