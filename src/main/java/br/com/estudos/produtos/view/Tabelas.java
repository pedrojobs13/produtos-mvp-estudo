package br.com.estudos.produtos.view;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

final class Tabelas {
    private Tabelas() { }

    static void preencher(JTable tabela, String[][] linhas) {
        String[] colunas = new String[tabela.getColumnCount()];
        for (int i = 0; i < colunas.length; i++) colunas[i] = tabela.getColumnName(i);
        tabela.setModel(new DefaultTableModel(linhas, colunas) {
            @Override public boolean isCellEditable(int linha, int coluna) { return false; }
        });
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }
}

