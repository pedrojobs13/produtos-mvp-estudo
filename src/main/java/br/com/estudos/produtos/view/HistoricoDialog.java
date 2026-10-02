/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.IHistoricoView;

public class HistoricoDialog extends javax.swing.JDialog implements IHistoricoView {
    public HistoricoDialog() {
        super((java.awt.Frame) null, true);
        initComponents();
        pack();
        setLocationRelativeTo(null);
    }


    @Override
    public void exibir() {
        setVisible(true);
    }


    @Override
    public void fechar() {
        dispose();
    }

    @Override
    public void mensagem(String texto) {
        javax.swing.JOptionPane.showMessageDialog(this, texto, "Atenção", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public boolean confirmar(String texto) {
        return javax.swing.JOptionPane.showConfirmDialog(this, texto, "Confirmação",
                javax.swing.JOptionPane.YES_NO_OPTION) == javax.swing.JOptionPane.YES_OPTION;
    }


    @Override
    public void mostrarProduto(String nome, String categoria) {
        txtProduto.setText(nome); txtCategoria.setText(categoria);
    }


    @Override
    public void mostrarHistorico(String[][] linhas) {
        Tabelas.preencher(tabela, linhas);
    }

    @Override
    public void aoFechar(Runnable acao) {
        Eventos.adicionarAcao(btnFechar, acao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        dados = new javax.swing.JPanel();
        lblProduto = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        rolagem = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botoes = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Preços do Produto");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));

        dados.setLayout(new java.awt.GridBagLayout());

        lblProduto.setText("Produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblProduto, gridBagConstraints);

        txtProduto.setColumns(24);
        txtProduto.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtProduto, gridBagConstraints);

        lblCategoria.setText("Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblCategoria, gridBagConstraints);

        txtCategoria.setColumns(24);
        txtCategoria.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtCategoria, gridBagConstraints);

        getContentPane().add(dados, java.awt.BorderLayout.NORTH);

        rolagem.setPreferredSize(new java.awt.Dimension(720, 320));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Data", "Percentual de lucro (%)", "Preço de venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setRowHeight(24);
        rolagem.setViewportView(tabela);

        getContentPane().add(rolagem, java.awt.BorderLayout.CENTER);

        botoes.setLayout(new java.awt.FlowLayout(1, 8, 12));

        btnFechar.setText("Fechar");
        botoes.add(btnFechar);

        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnFechar;
    private javax.swing.JPanel dados;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JScrollPane rolagem;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
