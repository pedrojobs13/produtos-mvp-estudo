package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.ProdutoRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProdutoRepositoryMemoria implements ProdutoRepository {
    private final Map<Integer, Produto> dados = new LinkedHashMap<>();
    private int proximoId = 1;

    public int proximoId() { return proximoId++; }
    public void salvar(Produto produto) { dados.put(produto.getId(), produto); }
    public Optional<Produto> buscarPorId(int id) { return Optional.ofNullable(dados.get(id)); }
    public List<Produto> listar() { return List.copyOf(dados.values()); }
}

