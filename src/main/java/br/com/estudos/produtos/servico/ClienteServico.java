package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.repositorio.ClienteRepository;
import java.util.List;

public class ClienteServico {
    private final ClienteRepository clientes;

    public ClienteServico(ClienteRepository clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> listar() {
        return clientes.listar();
    }

    public Cliente obter(int id) {
        return clientes.buscarPorId(id)
                .orElseThrow(() -> new RegraNegocioException("Cliente não encontrado. "));
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
                    clientes.proximoId(),
                    nomeValido,
                    logradouroValido,
                    bairroValido,
                    cidadeValida,
                    ufValida
            );
        } else {
            cliente = obter(id);
            cliente.atualizar(
                    nomeValido,
                    logradouroValido,
                    bairroValido,
                    cidadeValida,
                    ufValida
            );
        }

        clientes.salvar(cliente);
        return cliente;
    }

    public void excluir(int id) {
        obter(id);
        clientes.excluir(id);
    }

    private String validarUf(String uf) {
        String ufValida = Validacao.nome(uf, "UF").toUpperCase();

        if (ufValida.length() != 2) {
            throw new RegraNegocioException("UF deve possuir 2 letras. ");
        }

        return ufValida;
    }
}