package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.repositorio.CategoriaRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CategoriaRepositoryMemoria implements CategoriaRepository {
    private final Map<Integer, Categoria> dados = new LinkedHashMap<>();
    private int proximoId = 1;

    public int proximoId() { return proximoId++; }
    public void salvar(Categoria categoria) { dados.put(categoria.getId(), categoria); }
    public void excluir(int id) { dados.remove(id); }
    public Optional<Categoria> buscarPorId(int id) { return Optional.ofNullable(dados.get(id)); }
    public List<Categoria> listar() { return List.copyOf(dados.values()); }
}

