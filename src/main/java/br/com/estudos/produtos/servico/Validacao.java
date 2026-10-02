/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estudos.produtos.servico;

final class Validacao {
    private Validacao() {
    }

    static String nome(String nome, String campo) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new RegraNegocioException(campo + " é obrigatório.");
        }
        return nome.trim();
    }

    static void numero(Double valor, String campo, boolean permiteZero) {
        if (valor == null || Double.isNaN(valor) || Double.isInfinite(valor)
                || valor < 0 || (!permiteZero && valor == 0)) {
            throw new RegraNegocioException(campo + (permiteZero
                    ? " deve ser um número maior ou igual a zero."
                    : " deve ser um número maior que zero."));
        }
    }
}

