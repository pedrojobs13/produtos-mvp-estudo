package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    int proximoId();

    void salvar(Cliente cliente);

    void excluir(int id);

    Optional<Cliente> buscarPorId(int id);

    List<Cliente> listar();
}