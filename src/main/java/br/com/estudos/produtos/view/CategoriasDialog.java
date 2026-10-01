package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.CategoriasView;

public class CategoriasDialog extends javax.swing.JDialog implements CategoriasView {
    public CategoriasDialog() {
        super((java.awt.Frame) null, true);
        initComponents();
        pack();
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
    @Override public String getPercentual() { return txtPercentual.getText(); }
    @Override public void mostrarDados(String nome, String percentual) { txtNome.setText(nome); txtPercentual.setText(percentual); }
    @Override public void mostrarCategorias(String[][] linhas) { Tabelas.preencher(tabela, linhas); }
    @Override public void selecionarLinha(int indice) {
        if (indice < 0) tabela.clearSelection(); else tabela.setRowSelectionInterval(indice, indice);
    }
    @Override public void definirModo(boolean editando, boolean selecionado, String descricao) {
        lblModo.setText("Modo: " + descricao);
        txtNome.setEditable(editando); txtPercentual.setEditable(editando);
        tabela.setEnabled(!editando);
        btnNovo.setEnabled(!editando); btnFechar.setEnabled(!editando);
        btnEditar.setEnabled(!editando && selecionado); btnExcluir.setEnabled(!editando && selecionado);
        btnSalvar.setEnabled(editando); btnCancelar.setEnabled(editando);
        setDefaultCloseOperation(editando ? javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE
                : javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    @Override public void aoSelecionar(Runnable acao) {
        tabela.getSelectionModel().addListSelectionListener(e -> { if (!e.getValueIsAdjusting()) acao.run(); });
    }
    @Override public int getLinha() { return tabela.getSelectedRow(); }
    @Override public void aoNovo(Runnable acao) { btnNovo.addActionListener(e -> acao.run()); }
    @Override public void aoEditar(Runnable acao) { btnEditar.addActionListener(e -> acao.run()); }
    @Override public void aoExcluir(Runnable acao) { btnExcluir.addActionListener(e -> acao.run()); }
    @Override public void aoSalvar(Runnable acao) { btnSalvar.addActionListener(e -> acao.run()); }
    @Override public void aoCancelar(Runnable acao) { btnCancelar.addActionListener(e -> acao.run()); }
    @Override public void aoFechar(Runnable acao) { btnFechar.addActionListener(e -> acao.run()); }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        superior = new javax.swing.JPanel();
        dados = new javax.swing.JPanel();
        lblModo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPercentual = new javax.swing.JLabel();
        txtPercentual = new javax.swing.JTextField();
        botoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        listagem = new javax.swing.JPanel();
        rolagem = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Categorias de Produtos");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));

        superior.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes da Categoria"));
        superior.setLayout(new java.awt.BorderLayout(8, 8));

        dados.setLayout(new java.awt.GridBagLayout());

        lblModo.setText("Modo: Visualização");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblModo, gridBagConstraints);

        lblNome.setText("Categoria:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblNome, gridBagConstraints);

        txtNome.setColumns(24);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtNome, gridBagConstraints);

        lblPercentual.setText("Percentual de lucro (%):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(lblPercentual, gridBagConstraints);

        txtPercentual.setColumns(24);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 8, 12);
        dados.add(txtPercentual, gridBagConstraints);

        superior.add(dados, java.awt.BorderLayout.CENTER);

        botoes.setLayout(new java.awt.FlowLayout(0, 8, 12));

        btnNovo.setText("Novo");
        botoes.add(btnNovo);

        btnEditar.setText("Editar");
        botoes.add(btnEditar);

        btnExcluir.setText("Excluir");
        botoes.add(btnExcluir);

        btnSalvar.setText("Salvar");
        botoes.add(btnSalvar);

        btnCancelar.setText("Cancelar");
        botoes.add(btnCancelar);

        btnFechar.setText("Fechar");
        botoes.add(btnFechar);

        superior.add(botoes, java.awt.BorderLayout.SOUTH);

        getContentPane().add(superior, java.awt.BorderLayout.NORTH);

        listagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias cadastradas"));
        listagem.setLayout(new java.awt.BorderLayout(8, 8));

        rolagem.setPreferredSize(new java.awt.Dimension(720, 320));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Percentual de lucro (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setRowHeight(24);
        rolagem.setViewportView(tabela);

        listagem.add(rolagem, java.awt.BorderLayout.CENTER);

        getContentPane().add(listagem, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JPanel dados;
    private javax.swing.JLabel lblModo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPercentual;
    private javax.swing.JPanel listagem;
    private javax.swing.JScrollPane rolagem;
    private javax.swing.JPanel superior;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPercentual;
    // End of variables declaration//GEN-END:variables
}
