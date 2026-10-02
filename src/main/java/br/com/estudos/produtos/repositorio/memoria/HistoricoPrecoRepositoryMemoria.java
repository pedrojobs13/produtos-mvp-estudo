/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.repositorio.memoria;

import br.com.estudos.produtos.model.HistoricoPreco;
import br.com.estudos.produtos.repositorio.IHistoricoPrecoRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HistoricoPrecoRepositoryMemoria implements IHistoricoPrecoRepository {
    private List<HistoricoPreco> dados = new ArrayList<>();

    @Override
    public void salvarTodos(List<HistoricoPreco> registros) {
        dados.addAll(registros);
    }


    @Override
    public List<HistoricoPreco> listarPorProduto(int produtoId) {
        List<HistoricoPreco> encontrados = new ArrayList<>();
        for (HistoricoPreco historico : dados) {
            if (historico.getProdutoId() == produtoId) {
                encontrados.add(historico);
            }
        }
        Collections.sort(encontrados, new Comparator<HistoricoPreco>() {
            @Override
            public int compare(HistoricoPreco primeiro, HistoricoPreco segundo) {
                return segundo.getData().compareTo(primeiro.getData());
            }
        });
        return encontrados;
    }
}
