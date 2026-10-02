/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.repositorio.IUsuarioRepository;

public class AutenticacaoServico {
    private IUsuarioRepository usuarios;

    public AutenticacaoServico(IUsuarioRepository usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(String identificacao, String senha) {
        if (identificacao == null || identificacao.trim().isEmpty()) {
            throw new RegraNegocioException("Informe o usuário ou e-mail.");
        }

        if (senha == null || senha.trim().isEmpty()) {
            throw new RegraNegocioException("Informe a senha.");
        }

        for (Usuario usuario : usuarios.listar()) {
            boolean identificacaoCorreta = usuario.getNomeUsuario().equalsIgnoreCase(identificacao.trim())
                    || usuario.getEmail().equalsIgnoreCase(identificacao.trim());

            if (identificacaoCorreta) {
                if (!usuario.isHabilitado()) {
                    throw new RegraNegocioException("Usuário desabilitado.");
                }

                if (!usuario.getSenha().equals(senha)) {
                    throw new RegraNegocioException("Senha incorreta.");
                }

                return usuario;
            }
        }

        throw new RegraNegocioException("Usuário ou e-mail não encontrado.");
    }
}
