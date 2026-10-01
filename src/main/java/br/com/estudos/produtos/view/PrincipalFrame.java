package br.com.estudos.produtos.view;

import br.com.estudos.produtos.view.contrato.PrincipalView;

public class PrincipalFrame extends javax.swing.JFrame implements PrincipalView {
    public PrincipalFrame() {
        
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

    @Override public void aoIncluir(Runnable acao) { itemIncluir.addActionListener(e -> acao.run()); }
    @Override public void aoBuscar(Runnable acao) { itemBuscar.addActionListener(e -> acao.run()); }
    @Override public void aoCategorias(Runnable acao) { itemCategorias.addActionListener(e -> acao.run()); }
    @Override public void aoCalcular(Runnable acao) { itemCalcular.addActionListener(e -> acao.run()); }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaCentral = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        menuDados = new javax.swing.JMenu();
        itemIncluir = new javax.swing.JMenuItem();
        itemBuscar = new javax.swing.JMenuItem();
        itemCategorias = new javax.swing.JMenuItem();
        itemCalcular = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Supermercado");
        setPreferredSize(new java.awt.Dimension(860, 580));
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));

        areaCentral.setLayout(new java.awt.BorderLayout(8, 8));
        getContentPane().add(areaCentral, java.awt.BorderLayout.CENTER);

        menuDados.setText("Dados");

        itemIncluir.setText("Incluir produtos");
        menuDados.add(itemIncluir);

        itemBuscar.setText("Buscar produtos");
        menuDados.add(itemBuscar);

        itemCategorias.setText("Categorias");
        menuDados.add(itemCategorias);

        itemCalcular.setText("Calcular margem de lucro");
        menuDados.add(itemCalcular);

        barraMenu.add(menuDados);

        setJMenuBar(barraMenu);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaCentral;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem itemBuscar;
    private javax.swing.JMenuItem itemCalcular;
    private javax.swing.JMenuItem itemCategorias;
    private javax.swing.JMenuItem itemIncluir;
    private javax.swing.JMenu menuDados;
    // End of variables declaration//GEN-END:variables
}
