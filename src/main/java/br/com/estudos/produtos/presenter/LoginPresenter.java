/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.Usuario;
import br.com.estudos.produtos.servico.AutenticacaoServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.view.contrato.ILoginView;

public class LoginPresenter {
    private ILoginView view;
    private AutenticacaoServico service;
    private ILoginNavegacao navegacao;

    public LoginPresenter(ILoginView view, AutenticacaoServico service, ILoginNavegacao navegacao) {
        this.view = view;
        this.service = service;
        this.navegacao = navegacao;

        view.aoEntrar(new Runnable() {
            @Override
            public void run() {
                autentica();
            }
        });

        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
    }

    private void autentica() {
        try {
            Usuario usuario = service.autentica(view.getIdentificacao(), view.getSenha());
            view.fechar();
            navegacao.abrirPrincipal(usuario);
        } catch (RegraNegocioException e) {
            view.exibirMensagem(e.getMessage());
        }
    }
}
