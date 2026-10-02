/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

import br.com.estudos.produtos.model.HistoricoPreco;
import br.com.estudos.produtos.model.Produto;
import br.com.estudos.produtos.repositorio.IHistoricoPrecoRepository;
import br.com.estudos.produtos.repositorio.IProdutoRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalculoPrecoServico {
    private IProdutoRepository produtos;
    private IHistoricoPrecoRepository historicos;
    private LocalDate ultimoCalculo;

    public CalculoPrecoServico(IProdutoRepository produtos, IHistoricoPrecoRepository historicos) {
        this.produtos = produtos;
        this.historicos = historicos;
    }

    public LocalDate getUltimoCalculo() {
        return ultimoCalculo;
    }

    public List<Produto> calcular(LocalDate data) {
        if (data == null) {
            throw new RegraNegocioException("Informe a data do cálculo.");
        }
        if (ultimoCalculo != null) {
            LocalDate proximaData = ultimoCalculo.plusDays(10);
            if (data.isBefore(proximaData)) {
                throw new RegraNegocioException("O novo cálculo exige pelo menos 10 dias. Próxima data permitida: "
                        + proximaData.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            }
        }
        List<Produto> lista = produtos.listar();
        List<HistoricoPreco> novos = new ArrayList<>();
        // Primeiro valida todos os resultados, antes de alterar produtos ou históricos.
        for (Produto produto : lista) {
            Double margem = produto.getCategoria().getPercentualLucro();
            Double venda = calcularValor(produto.getPrecoCusto(), margem);
            novos.add(new HistoricoPreco(produto.getId(), data, margem, venda));
        }
        for (int i = 0; i < lista.size(); i++) {
            HistoricoPreco registro = novos.get(i);
            lista.get(i).atualizarPreco(registro.getPercentualLucro(), registro.getPrecoVenda());
        }
        historicos.salvarTodos(novos);
        ultimoCalculo = data;
        return lista;
    }

    public static Double calcularValor(Double custo, Double percentual) {
        Validacao.numero(custo, "Preço de custo", false);
        Validacao.numero(percentual, "Percentual de lucro", true);
        double valor = custo * (1 + percentual / 100);
        double centavos = valor * 100;
        if (Double.isNaN(centavos) || Double.isInfinite(centavos) || centavos >= Long.MAX_VALUE) {
            throw new RegraNegocioException("O preço calculado excede o limite suportado.");
        }
        return Math.round(centavos) / 100.0;
    }
}

