package org.example;

public class Main {
    public static void main(String[] args) {
        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Banco banco = new Banco("bradesco");

        Conta cc = new ContaCorrente(venilton, banco);
        Conta poupanca = new ContaPoupanca(venilton, banco);

        cc.depositar(1000);
        cc.transferir(100, poupanca);
        cc.investir(300);
        cc.resgatarInvestimento(200);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}