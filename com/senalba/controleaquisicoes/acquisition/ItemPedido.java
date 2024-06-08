package com.senalba.controleaquisicoes.acquisition;

public class ItemPedido {
    private String descricao;
    private double valorUnitario;
    private int quantidade;
    private double total;

    public ItemPedido(String descricao, double valorUnitario, int quantidade) {
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return valorUnitario * quantidade;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
