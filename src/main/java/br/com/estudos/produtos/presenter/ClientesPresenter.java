/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.servico.ClienteServico;
import br.com.estudos.produtos.view.contrato.IClientesView;
import java.util.ArrayList;
import java.util.List;

public class ClientesPresenter {
    private final IClientesView view;
    private final ClienteServico service;
    private List<Cliente> clientes = new ArrayList<>();

    public ClientesPresenter(IClientesView view, ClienteServico service) {
        this.view = view;
        this.service = service;

        view.aoSelecionar(new Runnable() {
            @Override
            public void run() {
                selecionar();
            }
        });
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
        atualizar();
    }

    private Cliente selecionado() {
        int indice = view.getLinha();
        if (indice >= 0 && indice < clientes.size()) {
            return clientes.get(indice);
        }
        return null;
    }

    private void atualizar() {
        clientes = service.listarTodos();
        String[][] linhas = new String[clientes.size()][5];

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            linhas[i] = new String[]{
                cliente.getNome(),
                cliente.getCidade(),
                cliente.getUf(),
                cliente.getTipo(),
                Formatos.numero(cliente.getTotalCompras())
            };
        }

        view.mostrarClientes(linhas);
        view.selecionarLinha(clientes.isEmpty() ? -1 : 0);
        selecionar();
    }

    private void selecionar() {
        Cliente cliente = selecionado();

        if (cliente == null) {
            view.mostrarDados("", "", "", "", "", "", "");
            return;
        }

        view.mostrarDados(
                cliente.getNome(),
                cliente.getLogradouro(),
                cliente.getBairro(),
                cliente.getCidade(),
                cliente.getUf(),
                cliente.getTipo(),
                Formatos.numero(cliente.getTotalCompras())
        );
    }
}
