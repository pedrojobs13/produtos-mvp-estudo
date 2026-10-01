package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.repositorio.UsuarioRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UsuarioRepositoryMemoria implements UsuarioRepository {
    private final Map<Integer, Usuario> dados = new LinkedHashMap<>();
    private int proximoId = 1;

    @Override
    public int proximoId() {
        return proximoId++;
    }

    @Override
    public void salvar(Usuario usuario) {
        dados.put(usuario.getId(), usuario);
    }

    @Override
    public void excluir(int id) {
        dados.remove(id);
    }

    @Override
    public Optional<Usuario> buscarPorId(int id) {
        return Optional.ofNullable(dados.get(id));
    }

    @Override
    public List<Usuario> listar() {
        return List.copyOf(dados.values());
    }
}