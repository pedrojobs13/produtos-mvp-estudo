package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.repositorio.ClienteRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClienteRepositoryMemoria implements ClienteRepository {
    private final Map<Integer, Cliente> dados = new LinkedHashMap<>();
    private int proximoId = 1;

    @Override
    public int proximoId() {
        return proximoId++;
    }

    @Override
    public void salvar(Cliente cliente) {
        dados.put(cliente.getId(), cliente);
    }

    @Override
    public void excluir(int id) {
        dados.remove(id);
    }

    @Override
    public Optional<Cliente> buscarPorId(int id) {
        return Optional.ofNullable(dados.get(id));
    }

    @Override
    public List<Cliente> listar() {
        return List.copyOf(dados.values());
    }
}