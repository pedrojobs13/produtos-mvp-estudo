package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.ProdutoEdicaoView;

public class ProdutoEdicaoDialog extends javax.swing.JDialog implements ProdutoEdicaoView {
    public ProdutoEdicaoDialog() {
        super((java.awt.Frame) null, true);
        initComponents();
        setLocationRelativeTo(null);
    }

    @Override public void exibir() { setVisible(true); }
    @Override public void fechar() { dispose(); }
    @Override public void mensagem(String texto) {
        javax.swing.JOptionPane.showMessageDialog(this, texto, "Atenção", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    @Override public boolean confirmar(String texto) {
        return javax.swing.JOptionPane.showConfirmDialog(this, texto, "Confirmação",
                javax.swing.JOptionPane.YES_NO_OPTION) == javax.swing.JOptionPane.YES_OPTION;
    }

    @Override public String getNome() { return txtNome.getText(); }
    @Override public String getCusto() { return txtCusto.getText(); }
    @Override public int getCategoriaIndice() { return cmbCategoria.getSelectedIndex(); }
    @Override public void mostrarCategorias(String[] nomes) { cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(nomes)); }
    @Override public void mostrarDados(String nome, String custo, int categoria, String margem, String venda) {
        txtNome.setText(nome); txtCusto.setText(custo); cmbCategoria.setSelectedIndex(categoria);
        txtMargem.setText(margem); txtVenda.setText(venda);
    }
    @Override public void aoSalvar(Runnable acao) { btnSalvar.addActionListener(e -> acao.run()); }
    @Override public void aoCancelar(Runnable acao) { btnCancelar.addActionListener(e -> acao.run()); }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;
        dados = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCusto = new javax.swing.JLabel();
        txtCusto = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblMargem = new javax.swing.JLabel();
        txtMargem = new javax.swing.JTextField();
        lblVenda = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        espaco = new javax.swing.JPanel();
        botoes = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto - Inclusão/Edição");
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));
        dados.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));
        dados.setLayout(new java.awt.GridBagLayout());
        lblNome.setText("Nome do produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblNome, gridBagConstraints);
        txtNome.setColumns(24);
        txtNome.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtNome, gridBagConstraints);
        lblCusto.setText("Preço de custo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblCusto, gridBagConstraints);
        txtCusto.setColumns(18);
        txtCusto.setEditable(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtCusto, gridBagConstraints);
        lblCategoria.setText("Categoria do produto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblCategoria, gridBagConstraints);
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(cmbCategoria, gridBagConstraints);
        lblMargem.setText("Margem de lucro (%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblMargem, gridBagConstraints);
        txtMargem.setColumns(18);
        txtMargem.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtMargem, gridBagConstraints);
        lblVenda.setText("Preço de venda:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblVenda, gridBagConstraints);
        txtVenda.setColumns(18);
        txtVenda.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.NONE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtVenda, gridBagConstraints);
        getContentPane().add(dados, java.awt.BorderLayout.NORTH);
        espaco.setLayout(new java.awt.BorderLayout(8, 8));
        getContentPane().add(espaco, java.awt.BorderLayout.CENTER);
        botoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 12));
        btnSalvar.setText("Salvar");
        botoes.add(btnSalvar);
        btnCancelar.setText("Cancelar");
        botoes.add(btnCancelar);
        getContentPane().add(botoes, java.awt.BorderLayout.SOUTH);
        pack();
    }//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dados;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtNome;
    private javax.swing.JLabel lblCusto;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel lblMargem;
    private javax.swing.JTextField txtMargem;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JTextField txtVenda;
    private javax.swing.JPanel espaco;
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnCancelar;
    // End of variables declaration//GEN-END:variables
}
