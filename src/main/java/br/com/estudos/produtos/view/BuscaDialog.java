/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.IBuscaView;

public class BuscaDialog extends javax.swing.JDialog implements IBuscaView {
    public BuscaDialog() {
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
    public String getTexto() {
        return txtBusca.getText();
    }


    @Override
    public boolean isBuscaCategoria() {
        return cmbBusca.getSelectedIndex() == 1;
    }

    @Override
    public void mostrarProdutos(String[][] linhas) {
        Tabelas.preencher(tabela, linhas);
    }

    @Override
    public void habilitarVisualizar(boolean habilitado) {
        btnVisualizar.setEnabled(habilitado);
    }

    @Override
    public void aoSelecionar(Runnable acao) {
        Eventos.adicionarSelecao(tabela, acao);
    }


    @Override
    public int getLinha() {
        return tabela.getSelectedRow();
    }

    @Override
    public void aoBuscar(Runnable acao) {
        Eventos.adicionarAcao(btnBuscar, acao);
    }

    @Override
    public void aoNovo(Runnable acao) {
        Eventos.adicionarAcao(btnNovo, acao);
    }

    @Override
    public void aoVisualizar(Runnable acao) {
        Eventos.adicionarAcao(btnVisualizar, acao);
    }

    @Override
    public void aoFechar(Runnable acao) {
        Eventos.adicionarAcao(btnFechar, acao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        filtros = new javax.swing.JPanel();
        lblBusca = new javax.swing.JLabel();
        cmbBusca = new javax.swing.JComboBox<>();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        rolagem = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        botoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Produtos");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));

        filtros.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));
        filtros.setLayout(new java.awt.GridBagLayout());

        lblBusca.setText("Busca por");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        filtros.add(lblBusca, gridBagConstraints);

        cmbBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome do produto", "Categoria" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        filtros.add(cmbBusca, gridBagConstraints);

        txtBusca.setColumns(24);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        filtros.add(txtBusca, gridBagConstraints);

        btnBuscar.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        filtros.add(btnBuscar, gridBagConstraints);

        getContentPane().add(filtros, java.awt.BorderLayout.NORTH);

        rolagem.setPreferredSize(new java.awt.Dimension(720, 320));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nome do produto", "Preço de custo", "Categoria", "Margem de lucro (%)", "Preço de venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setRowHeight(24);
        rolagem.setViewportView(tabela);

        getContentPane().add(rolagem, java.awt.BorderLayout.CENTER);

        botoes.setLayout(new java.awt.FlowLayout(0, 8, 12));

        btnNovo.setText("Novo");
        botoes.add(btnNovo);

        btnVisualizar.setText("Visualizar");
        botoes.add(btnVisualizar);

        btnFechar.setText("Fechar");
        botoes.add(btnFechar);

        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox<String> cmbBusca;
    private javax.swing.JPanel filtros;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JScrollPane rolagem;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
