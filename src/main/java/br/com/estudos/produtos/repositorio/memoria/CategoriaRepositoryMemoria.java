/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.repositorio.ICategoriaRepository;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryMemoria implements ICategoriaRepository {
    private List<Categoria> dados = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public int proximoId() {
        return proximoId++;
    }


    @Override
    public void salvar(Categoria categoria) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == categoria.getId()) {
                dados.set(i, categoria);
                return;
            }
        }
        dados.add(categoria);
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
    public Categoria consultar(int id) {
        for (Categoria categoria : dados) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }


    @Override
    public List<Categoria> listarTodos() {
        return new ArrayList<>(dados);
    }
}
