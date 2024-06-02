package com.senalba.controleaquisicoes.model;

public class Departamento {
    private final String nome;
    private double limitePorPedido;

    public Departamento(String nome, double limitePorPedido) {
        this.nome = nome;
        this.limitePorPedido = limitePorPedido;
    }

    public String getNome() {
        return nome;
    }
//teste


    public double getLimitePorPedido() {
        return limitePorPedido;
    }
}
