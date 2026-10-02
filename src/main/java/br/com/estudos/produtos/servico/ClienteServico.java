/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.repositorio.IClienteRepository;
import java.util.List;

public class ClienteServico {
    private IClienteRepository clienteRepository;

    public ClienteServico(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.listarTodos();
    }

    public Cliente consultar(int id) {
        Cliente cliente = clienteRepository.consultar(id);
        if (cliente == null) {
            throw new RegraNegocioException("Cliente não encontrado.");
        }
        return cliente;
    }

    public Cliente salvar(Integer id, String nome, String logradouro,
            String bairro, String cidade, String uf) {
        String nomeValido = Validacao.nome(nome, "Nome do cliente ");
        String logradouroValido = Validacao.nome(logradouro, "Logradouro");
        String bairroValido = Validacao.nome(bairro, "Bairro");
        String cidadeValida = Validacao.nome(cidade, "Cidade");
        String ufValida = validarUf(uf);

        Cliente cliente;

        if (id == null) {
            cliente = new Cliente(
                    clienteRepository.proximoId(),
                    nomeValido,
                    logradouroValido,
                    bairroValido,
                    cidadeValida,
                    ufValida
            );
        } else {
            cliente = consultar(id);
            cliente.atualizar(
                    nomeValido,
                    logradouroValido,
                    bairroValido,
                    cidadeValida,
                    ufValida
            );
        }

        clienteRepository.salvar(cliente);
        return cliente;
    }

    public void excluir(int id) {
        consultar(id);
        clienteRepository.excluir(id);
    }

    private String validarUf(String uf) {
        String ufValida = Validacao.nome(uf, "UF").toUpperCase();

        if (ufValida.length() != 2) {
            throw new RegraNegocioException("UF deve possuir 2 letras. ");
        }

        return ufValida;
    }
}
