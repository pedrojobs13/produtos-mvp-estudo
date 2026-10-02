/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ReflectiveOperationException e) {
                    System.err.println("Será utilizado o tema padrão do Java: " + e.getMessage());
                } catch (javax.swing.UnsupportedLookAndFeelException e) {
                    System.err.println("Será utilizado o tema padrão do Java: " + e.getMessage());
                }
                try {
                    new Aplicacao().iniciar();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possível iniciar o sistema: " + e.getMessage(),
                            "Erro de inicialização", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

