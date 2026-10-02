/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.model;

public class Usuario {
    public static final String ADMINISTRADOR = "ADMINISTRADOR";
    public static final String ATENDENTE = "ATENDENTE";
    public static final String CLIENTE = "CLIENTE";

    private final int id;
    private String nome;
    private String email;
    private String nomeUsuario;
    private String senha;
    private String perfil;
    private boolean habilitado;
    private Cliente cliente;

    public Usuario(int id, String nome, String email, String nomeUsuario,
            String senha, String perfil, boolean habilitado, Cliente cliente) {
        this.id = id;
        atualizar(nome, email, nomeUsuario, senha, perfil, cliente);
        this.habilitado = habilitado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void atualizar(String nome, String email, String nomeUsuario,
            String senha, String perfil, Cliente cliente) {
        this.nome = nome;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.perfil = perfil;
        this.cliente = cliente;
    }

    public void alterarStatus(boolean habilitado) {
        this.habilitado = habilitado;
    }
}