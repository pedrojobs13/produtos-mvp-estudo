/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Categoria;
import java.util.List;

public interface ICategoriaRepository {
    int proximoId();
    void salvar(Categoria categoria);
    void excluir(int id);
    Categoria consultar(int id);
    List<Categoria> listarTodos();
}
