/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.servico.UsuarioServico;
import br.com.estudos.produtos.view.contrato.IUsuariosView;
import java.util.ArrayList;
import java.util.List;

public class UsuariosPresenter {
    private final IUsuariosView view;
    private final UsuarioServico service;
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuariosPresenter(IUsuariosView view, UsuarioServico service) {
        this.view = view;
        this.service = service;

        view.aoSelecionar(new Runnable() {
            @Override
            public void run() {
                selecionar();
            }
        });
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
        atualizar();
    }

    private Usuario selecionado() {
        int indice = view.getLinha();
        if (indice >= 0 && indice < usuarios.size()) {
            return usuarios.get(indice);
        }
        return null;
    }

    private void atualizar() {
        usuarios = service.listarTodos();
        String[][] linhas = new String[usuarios.size()][5];

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            String cliente = usuario.getCliente() == null ? "" : usuario.getCliente().getNome();
            String status = usuario.isHabilitado() ? "Habilitado" : "Desabilitado";
            linhas[i] = new String[]{
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getPerfil(),
                status,
                cliente
            };
        }

        view.mostrarUsuarios(linhas);
        view.selecionarLinha(usuarios.isEmpty() ? -1 : 0);
        selecionar();
    }

    private void selecionar() {
        Usuario usuario = selecionado();

        if (usuario == null) {
            view.mostrarDados("", "", "", "", "", "");
            return;
        }

        String cliente = usuario.getCliente() == null ? "" : usuario.getCliente().getNome();
        String status = usuario.isHabilitado() ? "Habilitado" : "Desabilitado";
        view.mostrarDados(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getNomeUsuario(),
                usuario.getPerfil(),
                status,
                cliente
        );
    }
}
