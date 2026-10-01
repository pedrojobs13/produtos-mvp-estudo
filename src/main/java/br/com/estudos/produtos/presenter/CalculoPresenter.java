package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.servico.CalculoPrecoServico;
import br.com.estudos.produtos.servico.RegraNegocioException;
import br.com.estudos.produtos.view.contrato.CalculoView;
import java.time.LocalDate;

public class CalculoPresenter {
    private final CalculoView view;
    private final CalculoPrecoServico servico;

    public CalculoPresenter(CalculoView view, CalculoPrecoServico servico) {
        this.view = view;
        this.servico = servico;
        view.mostrarData(Formatos.data(LocalDate.now()));
        atualizarAviso();
        view.aoCalcular(this::calcular);
        view.aoFechar(view::fechar);
    }

    private void atualizarAviso() {
        LocalDate ultima = servico.getUltimoCalculo();
        view.mostrarAviso(ultima == null ? "Primeiro cálculo disponível." :
                "Último cálculo: " + Formatos.data(ultima) + ". Próximo permitido: " + Formatos.data(ultima.plusDays(10)) + ".");
    }

    private void calcular() {
        try {
            view.mostrarResultados(Formatos.produtos(servico.calcular(Formatos.lerData(view.getData()))));
            atualizarAviso();
        } catch (RegraNegocioException e) {
            view.mensagem(e.getMessage());
        }
    }
}

