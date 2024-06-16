package org.example;

public class AgenciaInvestimentos {
    private Conta conta;

    private double saldoInvestimentos = 0;

    public boolean verificarInvestimentoDisponivel (double valor) {
        if (valor >= 200 ) {
            System.out.println("Temos investimento liberados para sua conta !");
            saldoInvestimentos += valor;
            return true;
        } else {
            System.out.println("Infelizmente não temos investimentos disponiveis para sua conta");
            return false;
        }
    }
}
