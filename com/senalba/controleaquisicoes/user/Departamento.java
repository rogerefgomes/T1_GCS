package com.senalba.controleaquisicoes.user;

public class Departamento {
    private String nome;
    private double limitePorPedido;

    public Departamento(String nome, double limitePorPedido) {
        this.nome = nome;
        this.limitePorPedido = limitePorPedido;
    }

    public String getNome() {
        return nome;
    }

    public double getLimitePorPedido() {
        return limitePorPedido;
    }
}
