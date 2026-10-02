/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.HistoricoPreco;
import java.util.List;

public interface IHistoricoPrecoRepository {
    void salvarTodos(List<HistoricoPreco> registros);
    List<HistoricoPreco> listarPorProduto(int produtoId);
}

