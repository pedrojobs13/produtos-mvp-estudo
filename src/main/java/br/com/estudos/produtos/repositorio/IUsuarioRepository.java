/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio;

import br.com.estudos.produtos.model.Usuario;
import java.util.List;

public interface IUsuarioRepository {
    int proximoId();

    void salvar(Usuario usuario);

    void excluir(int id);

    Usuario buscarPorId(int id);

    List<Usuario> listar();
}
