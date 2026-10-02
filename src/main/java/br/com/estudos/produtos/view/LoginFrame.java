/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.ILoginView;

public class LoginFrame extends javax.swing.JFrame implements ILoginView {
    public LoginFrame() {
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
    public String getIdentificacao() {
        return txtIdentificacao.getText();
    }

    @Override
    public String getSenha() {
        return new String(txtSenha.getPassword());
    }

    @Override
    public void aoEntrar(Runnable acao) {
        Eventos.adicionarAcao(btnEntrar, acao);
    }

    @Override
    public void aoFechar(Runnable acao) {
        Eventos.adicionarAcao(btnFechar, acao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        painel = new javax.swing.JPanel();
        lblIdentificacao = new javax.swing.JLabel();
        txtIdentificacao = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        painel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        painel.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagConstraints restricoes = new java.awt.GridBagConstraints();
        restricoes.gridx = 0;
        restricoes.gridy = 0;
        restricoes.anchor = java.awt.GridBagConstraints.WEST;
        restricoes.insets = new java.awt.Insets(4, 4, 4, 4);
        painel.add(lblIdentificacao, restricoes);

        restricoes = new java.awt.GridBagConstraints();
        restricoes.gridx = 1;
        restricoes.gridy = 0;
        restricoes.fill = java.awt.GridBagConstraints.HORIZONTAL;
        restricoes.weightx = 1.0;
        restricoes.insets = new java.awt.Insets(4, 4, 4, 4);
        painel.add(txtIdentificacao, restricoes);

        restricoes = new java.awt.GridBagConstraints();
        restricoes.gridx = 0;
        restricoes.gridy = 1;
        restricoes.anchor = java.awt.GridBagConstraints.WEST;
        restricoes.insets = new java.awt.Insets(4, 4, 4, 4);
        painel.add(lblSenha, restricoes);

        restricoes = new java.awt.GridBagConstraints();
        restricoes.gridx = 1;
        restricoes.gridy = 1;
        restricoes.fill = java.awt.GridBagConstraints.HORIZONTAL;
        restricoes.weightx = 1.0;
        restricoes.insets = new java.awt.Insets(4, 4, 4, 4);
        painel.add(txtSenha, restricoes);

        restricoes = new java.awt.GridBagConstraints();
        restricoes.gridx = 0;
        restricoes.gridy = 2;
        restricoes.gridwidth = 1;
        restricoes.anchor = java.awt.GridBagConstraints.EAST;
        restricoes.insets = new java.awt.Insets(12, 4, 4, 4);
        painel.add(btnEntrar, restricoes);

        restricoes = new java.awt.GridBagConstraints();
        restricoes.gridx = 1;
        restricoes.gridy = 2;
        restricoes.anchor = java.awt.GridBagConstraints.EAST;
        restricoes.insets = new java.awt.Insets(12, 4, 4, 4);
        painel.add(btnFechar, restricoes);

        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        lblIdentificacao.setText("Usuário ou e-mail:");
        lblSenha.setText("Senha:");
        txtIdentificacao.setColumns(20);
        btnEntrar.setText("Entrar");
        btnFechar.setText("Fechar");
        getRootPane().setDefaultButton(btnEntrar);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel lblIdentificacao;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField txtIdentificacao;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
