/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.repositorio.IUsuarioRepository;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryMemoria implements IUsuarioRepository {
    private List<Usuario> dados = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public int proximoId() {
        return proximoId++;
    }


    @Override
    public void salvar(Usuario usuario) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == usuario.getId()) {
                dados.set(i, usuario);
                return;
            }
        }
        dados.add(usuario);
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
    public Usuario consultar(int id) {
        for (Usuario usuario : dados) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }


    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(dados);
    }
}
