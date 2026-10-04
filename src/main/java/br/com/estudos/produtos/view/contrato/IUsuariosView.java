/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.estudos.produtos.view.contrato;

public interface IUsuariosView extends IJanelaView {
    String getNome();
    String getEmail();
    String getNomeUsuario();
    String getSenha();
    String getConfirmaSenha();
    String getPerfil();
    String getCliente();
    int getLinha();
    void mostrarDados(String nome, String email, String nomeUsuario,
            String perfil, String status, String cliente);
    void mostrarClientes(String[] clientes);
    void mostrarUsuarios(String[][] linhas);
    void selecionarLinha(int indice);
    void definirModo(boolean editando, boolean selecionado, boolean administrador,
            boolean habilitado, String descricao);
    void alternarSenha();
    void aoNovo(Runnable acao);
    void aoEditar(Runnable acao);
    void aoExcluir(Runnable acao);
    void aoSalvar(Runnable acao);
    void aoCancelar(Runnable acao);
    void aoHabilitar(Runnable acao);
    void aoDesabilitar(Runnable acao);
    void aoMostrarSenha(Runnable acao);
    void aoIncluirCliente(Runnable acao);
    void aoSelecionar(Runnable acao);
    void aoFechar(Runnable acao);
}
