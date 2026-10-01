package br.com.estudos.produtos.presenter;

import br.com.estudos.produtos.model.HistoricoPreco;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.HistoricoPrecoRepository;
import br.com.estudos.produtos.servico.ProdutoServico;
import br.com.estudos.produtos.view.contrato.HistoricoView;
import java.util.List;

public class HistoricoPresenter {
    public HistoricoPresenter(HistoricoView view, ProdutoServico produtos, HistoricoPrecoRepository historicos, int id) {
        Produto produto = produtos.obter(id);
        view.mostrarProduto(produto.getNome(), produto.getCategoria().getNome());
        List<HistoricoPreco> registros = historicos.listarPorProduto(id);
        String[][] linhas = new String[registros.size()][3];
        for (int i = 0; i < registros.size(); i++) {
            HistoricoPreco h = registros.get(i);
            linhas[i] = new String[] {Formatos.data(h.getData()), Formatos.numero(h.getPercentualLucro()),
                    Formatos.numero(h.getPrecoVenda())};
        }
        view.mostrarHistorico(linhas);
        view.aoFechar(view::fechar);
    }
}

