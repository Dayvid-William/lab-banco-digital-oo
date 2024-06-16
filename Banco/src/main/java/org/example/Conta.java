package org.example;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

    AgenciaInvestimentos agenciaIv = new AgenciaInvestimentos();

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected Banco banco;

    protected double saldoInvestimentos = 0;

    public Conta(Cliente cliente, Banco banco) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.banco = banco;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println(String.format("Banco: %s", this.banco));
        System.out.println(String.format("Saldo Investido: %.2f", this.saldoInvestimentos));
    }

    public void investir(double valor) {

        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente!");
        }else if (agenciaIv.verificarInvestimentoDisponivel(valor)) {
            this.saldo -= valor;
            this.saldoInvestimentos += valor;
            System.out.println("Investimento realizado com sucesso saldo atual: " + saldo);
        } else {
            System.out.println("Erro na operação");
        }
    }

    public void resgatarInvestimento(double valorResgatado) {

        if (valorResgatado > this.saldoInvestimentos) {
            System.out.println("Saldo insuficiente!");
        }else {
            this.saldo += valorResgatado;
            this.saldoInvestimentos -= valorResgatado;
            System.out.println("Investimento resgatado com sucesso saldo atual: " + saldo);
        }
    }
}