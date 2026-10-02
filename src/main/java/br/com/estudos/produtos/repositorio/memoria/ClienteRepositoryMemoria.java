/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.repositorio.IClienteRepository;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria implements IClienteRepository {
    private List<Cliente> dados = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public int proximoId() {
        return proximoId++;
    }


    @Override
    public void salvar(Cliente cliente) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == cliente.getId()) {
                dados.set(i, cliente);
                return;
            }
        }
        dados.add(cliente);
    }


    @Override
    public void excluir(int id) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == id) {
                dados.remove(i);
                return;
            }
        }
    }


    @Override
    public Cliente consultar(int id) {
        for (Cliente cliente : dados) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }


    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(dados);
    }
}
