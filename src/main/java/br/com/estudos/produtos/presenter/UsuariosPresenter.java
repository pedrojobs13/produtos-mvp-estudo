/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Cliente;
import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.servico.ClienteServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.servico.UsuarioServico;
import br.com.estudos.produtos.view.contrato.IUsuariosView;
import java.util.ArrayList;
import java.util.List;

public class UsuariosPresenter {
    private final IUsuariosView view;
    private final UsuarioServico service;
    private final ClienteServico clienteServico;
    private final Usuario administrador;
    private final IUsuariosNavegacao navegacao;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private Integer idEdicao;
    private boolean editando;

    public UsuariosPresenter(IUsuariosView view, UsuarioServico service,
            ClienteServico clienteServico, Usuario administrador, IUsuariosNavegacao navegacao) {
        this.view = view;
        this.service = service;
        this.clienteServico = clienteServico;
        this.administrador = administrador;
        this.navegacao = navegacao;

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
                cancelar();
            }
        });
        view.aoHabilitar(new Runnable() {
            @Override
            public void run() {
                alterarStatus(true);
            }
        });
        view.aoDesabilitar(new Runnable() {
            @Override
            public void run() {
                alterarStatus(false);
            }
        });
        view.aoMostrarSenha(new Runnable() {
            @Override
            public void run() {
                view.alternarSenha();
            }
        });
        view.aoIncluirCliente(new Runnable() {
            @Override
            public void run() {
                navegacao.incluirCliente();
                atualizar();
            }
        });
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

    private Cliente clienteSelecionado() {
        String nome = view.getCliente();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    private void atualizar() {
        usuarios = service.listarTodos();
        clientes = clienteServico.listarTodos();

        String[] nomesClientes = new String[clientes.size()];
        for (int i = 0; i < clientes.size(); i++) {
            nomesClientes[i] = clientes.get(i).getNome();
        }
        view.mostrarClientes(nomesClientes);

        String[][] linhas = new String[usuarios.size()][5];
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            linhas[i] = new String[]{
                usuario.getNome(),
                usuario.getNomeUsuario(),
                usuario.getPerfil(),
                usuario.isHabilitado() ? "Habilitado" : "Desabilitado",
                usuario.getCliente() == null ? "" : usuario.getCliente().getNome()
            };
        }

        view.mostrarUsuarios(linhas);
        view.selecionarLinha(usuarios.isEmpty() ? -1 : 0);
        selecionar();
    }

    private void selecionar() {
        if (editando) {
            return;
        }

        Usuario usuario = selecionado();
        if (usuario == null) {
            view.mostrarDados("", "", "", "", "", "");
            view.definirModo(false, false, false, false, "Visualização");
            return;
        }

        view.mostrarDados(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getNomeUsuario(),
                usuario.getPerfil(),
                usuario.isHabilitado() ? "Habilitado" : "Desabilitado",
                usuario.getCliente() == null ? "" : usuario.getCliente().getNome()
        );
        boolean administradorSelecionado = Usuario.ADMINISTRADOR.equals(usuario.getPerfil());
        view.definirModo(false, true, administradorSelecionado, usuario.isHabilitado(), "Visualização");
    }

    private void novo() {
        idEdicao = null;
        editando = true;
        view.mostrarDados("", "", "", Usuario.CLIENTE, "Habilitado", "");
        view.definirModo(true, false, false, true, "Inclusão");
    }

    private void editar() {
        Usuario usuario = selecionado();
        if (usuario == null || Usuario.ADMINISTRADOR.equals(usuario.getPerfil())) {
            return;
        }

        idEdicao = usuario.getId();
        editando = true;
        view.definirModo(true, true, false, usuario.isHabilitado(), "Edição");
    }

    private void salvar() {
        try {
            String senha = view.getSenha();
            String confirmaSenha = view.getConfirmaSenha();

            if (!senha.equals(confirmaSenha)) {
                throw new RegraNegocioException("Senha e confirmação de senha não conferem.");
            }

            service.salvar(
                    administrador,
                    idEdicao,
                    view.getNome(),
                    view.getEmail(),
                    view.getNomeUsuario(),
                    senha,
                    view.getPerfil(),
                    clienteSelecionado()
            );
            editando = false;
            atualizar();
        } catch (RegraNegocioException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    private void cancelar() {
        editando = false;
        atualizar();
    }

    private void excluir() {
        Usuario usuario = selecionado();
        if (usuario == null || Usuario.ADMINISTRADOR.equals(usuario.getPerfil())) {
            return;
        }

        if (!view.exibirConfirmacao("Excluir o usuário " + usuario.getNome() + "?")) {
            return;
        }

        try {
            service.excluir(administrador, usuario.getId());
            atualizar();
        } catch (RegraNegocioException e) {
            view.exibirMensagem(e.getMessage());
        }
    }

    private void alterarStatus(boolean habilitado) {
        Usuario usuario = selecionado();
        if (usuario == null || Usuario.ADMINISTRADOR.equals(usuario.getPerfil())) {
            return;
        }

        try {
            service.alterarStatus(administrador, usuario.getId(), habilitado);
            atualizar();
        } catch (RegraNegocioException e) {
            view.exibirMensagem(e.getMessage());
        }
    }
}
