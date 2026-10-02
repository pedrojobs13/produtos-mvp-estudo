/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Cliente;
import java.util.List;

public interface IClienteRepository {
    int proximoId();

    void salvar(Cliente cliente);

    void excluir(int id);

    Cliente buscarPorId(int id);

    List<Cliente> listar();
}
