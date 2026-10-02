/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.ICalculoView;

public class CalculoDialog extends javax.swing.JDialog implements ICalculoView {
    public CalculoDialog() {
        super((java.awt.Frame) null, true);
        initComponents();
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
    public String getData() {
        return txtData.getText();
    }


    @Override
    public void mostrarData(String data) {
        txtData.setText(data);
    }

    @Override
    public void mostrarAviso(String texto) {
        lblAviso.setText(texto);
    }

    @Override
    public void mostrarResultados(String[][] linhas) {
        Tabelas.preencher(tabela, linhas);
    }

    @Override
    public void aoCalcular(Runnable acao) {
        Eventos.adicionarAcao(btnCalcular, acao);
    }

    @Override
    public void aoFechar(Runnable acao) {
        Eventos.adicionarAcao(btnFechar, acao);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;
        filtros = new javax.swing.JPanel();
        dataCalculo = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        rolagem = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botoes = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cálculo de Margem de Lucro");
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
        filtros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        filtros.setLayout(new java.awt.BorderLayout(8, 8));
        dataCalculo.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 12));
        lblData.setText("Data do cálculo (dd/MM/aaaa):");
        dataCalculo.add(lblData);
        txtData.setColumns(24);
        txtData.setEditable(true);
        dataCalculo.add(txtData);
        btnCalcular.setText("Calcular");
        dataCalculo.add(btnCalcular);
        filtros.add(dataCalculo, java.awt.BorderLayout.NORTH);
        lblAviso.setText("O cálculo só pode ser realizado novamente após 10 dias.");
        filtros.add(lblAviso, java.awt.BorderLayout.SOUTH);
        getContentPane().add(filtros, java.awt.BorderLayout.NORTH);
        rolagem.setPreferredSize(new java.awt.Dimension(720, 320));
        tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[0][5], new String[] {"Nome do produto", "Preço unitário", "Categoria", "Percentual de lucro", "Preço de venda calculado"}) { public boolean isCellEditable(int row, int column) { return false; } });
        tabela.setRowHeight(24);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rolagem.setViewportView(tabela);
        getContentPane().add(rolagem, java.awt.BorderLayout.CENTER);
        botoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 12));
        btnFechar.setText("Fechar");
        botoes.add(btnFechar);
        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);
        pack();
    }//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel filtros;
    private javax.swing.JPanel dataCalculo;
    private javax.swing.JLabel lblData;
    private javax.swing.JTextField txtData;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JScrollPane rolagem;
    private javax.swing.JTable tabela;
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnFechar;
    // End of variables declaration//GEN-END:variables
}
