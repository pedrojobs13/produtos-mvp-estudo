package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.ProdutoDetalheView;

public class ProdutoDetalheDialog extends javax.swing.JDialog implements ProdutoDetalheView {
    public ProdutoDetalheDialog() {
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

    @Override public void mostrarDados(String nome, String custo, String categoria, String margem, String venda) {
        txtNome.setText(nome); txtCusto.setText(custo); txtCategoria.setText(categoria);
        txtMargem.setText(margem); txtVenda.setText(venda);
    }
    @Override public void aoEditar(Runnable acao) { btnEditar.addActionListener(e -> acao.run()); }
    @Override public void aoHistorico(Runnable acao) { btnHistorico.addActionListener(e -> acao.run()); }
    @Override public void aoFechar(Runnable acao) { btnFechar.addActionListener(e -> acao.run()); }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;
        dados = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCusto = new javax.swing.JLabel();
        txtCusto = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        lblMargem = new javax.swing.JLabel();
        txtMargem = new javax.swing.JTextField();
        lblVenda = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        acoesHistorico = new javax.swing.JPanel();
        btnHistorico = new javax.swing.JButton();
        botoes = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto - Visualização");
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
        txtNome.setEditable(false);
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
        txtCusto.setEditable(false);
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
        txtCategoria.setColumns(24);
        txtCategoria.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtCategoria, gridBagConstraints);
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
        acoesHistorico.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 8, 12));
        btnHistorico.setText("Visualizar histórico de preços");
        acoesHistorico.add(btnHistorico);
        getContentPane().add(acoesHistorico, java.awt.BorderLayout.CENTER);
        botoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 12));
        btnEditar.setText("Editar");
        botoes.add(btnEditar);
        btnFechar.setText("Fechar");
        botoes.add(btnFechar);
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
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JLabel lblMargem;
    private javax.swing.JTextField txtMargem;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JTextField txtVenda;
    private javax.swing.JPanel acoesHistorico;
    private javax.swing.JButton btnHistorico;
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    // End of variables declaration//GEN-END:variables
}
