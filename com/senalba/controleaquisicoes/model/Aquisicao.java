
package com.senalba.controleaquisicoes.model;

public class Aquisicao
{
    private int id;
    private String descricao;
    private double valor;
    private int quantidade;

    public Aquisicao(int id, String descricao, double valor, int quantidade)
    {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public int getId()
    {
        return id;
    }

    public String getDescricao()
    {
        return descricao;
    }


}

