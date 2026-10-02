/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.servico.CalculoPrecoServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.view.contrato.ICalculoView;
import java.time.LocalDate;

public class CalculoPresenter {
    private final ICalculoView view;
    private final CalculoPrecoServico service;

    public CalculoPresenter(ICalculoView view, CalculoPrecoServico service) {
        this.view = view;
        this.service = service;
        view.mostrarData(Formatos.data(LocalDate.now()));
        atualizarAviso();
        view.aoCalcular(new Runnable() {
            @Override
            public void run() {
                calcular();
            }
        });
        view.aoFechar(new Runnable() {
            @Override
            public void run() {
                view.fechar();
            }
        });
    }

    private void atualizarAviso() {
        LocalDate ultima = service.getUltimoCalculo();
        view.mostrarAviso(ultima == null ? "Primeiro cálculo disponível." :
                "Último cálculo: " + Formatos.data(ultima) + ". Próximo permitido: " + Formatos.data(ultima.plusDays(10)) + ".");
    }

    private void calcular() {
        try {
            view.mostrarResultados(Formatos.produtos(service.calcular(Formatos.lerData(view.getData()))));
            atualizarAviso();
        } catch (RegraNegocioException e) {
            view.exibirMensagem(e.getMessage());
        }
    }
}
