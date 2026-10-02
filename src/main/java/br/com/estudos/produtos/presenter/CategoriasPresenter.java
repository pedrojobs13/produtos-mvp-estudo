/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Categoria;
import br.com.estudos.produtos.servico.CategoriaServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.view.contrato.ICategoriasView;
import java.util.ArrayList;
import java.util.List;

public class CategoriasPresenter {
    private final ICategoriasView view;
    private final CategoriaServico servico;
    private List<Categoria> categorias = new ArrayList<>();
    private Integer idEdicao;
    private boolean editando;

    public CategoriasPresenter(ICategoriasView view, CategoriaServico servico) {
        this.view = view;
        this.servico = servico;
        view.aoNovo(new Runnable() {
            @Override
            public void run() {
                novo();
            }
        });
        view.aoEditar(new Runnable() {
            @Override
            public void run() {
                editar();
            }
        });
        view.aoExcluir(new Runnable() {
            @Override
            public void run() {
                excluir();
            }
        });
        view.aoSalvar(new Runnable() {
            @Override
            public void run() {
                salvar();
            }
        });
        view.aoCancelar(new Runnable() {
            @Override
            public void run() {
                editando = false;
                atualizar();
            }
        });
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
        view.aoSelecionar(new Runnable() {
            @Override
            public void run() {
                selecionar();
            }
        });
        atualizar();
    }

    private Categoria selecionada() {
        int indice = view.getLinha();
        return indice >= 0 && indice < categorias.size() ? categorias.get(indice) : null;
    }

    private void atualizar() {
        categorias = servico.listar();
        String[][] linhas = new String[categorias.size()][2];
        for (int i = 0; i < categorias.size(); i++) {
            Categoria c = categorias.get(i);
            linhas[i] = new String[] {c.getNome(), Formatos.numero(c.getPercentualLucro())};
        }
        view.mostrarCategorias(linhas);
        view.selecionarLinha(categorias.isEmpty() ? -1 : 0);
        selecionar();
    }

    private void selecionar() {
        if (editando) return;
        Categoria c = selecionada();
        view.mostrarDados(c == null ? "" : c.getNome(), c == null ? "" : Formatos.numero(c.getPercentualLucro()));
        view.definirModo(false, c != null, "Visualização");
    }

    private void novo() {
        idEdicao = null;
        editando = true;
        view.mostrarDados("", "");
        view.definirModo(true, false, "Inclusão");
    }

    private void editar() {
        Categoria c = selecionada();
        if (c == null) return;
        idEdicao = c.getId();
        editando = true;
        view.definirModo(true, true, "Edição");
    }

    private void salvar() {
        try {
            servico.salvar(idEdicao, view.getNome(), Formatos.lerNumero(view.getPercentual(), "o percentual"));
            editando = false;
            atualizar();
        } catch (RegraNegocioException e) {
            view.mensagem(e.getMessage());
        }
    }

    private void excluir() {
        Categoria c = selecionada();
        if (c == null || !view.confirmar("Excluir a categoria " + c.getNome() + "?")) return;
        try {
            servico.excluir(c.getId());
            atualizar();
        } catch (RegraNegocioException e) {
            view.mensagem(e.getMessage());
        }
    }
}

