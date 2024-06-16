package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Banco {

    private String nome;
    private List<Conta> contas;
    public Banco(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}