
package com.senalba.controleaquisicoes.model;

public class Aquisicao
{
    private int id;
    private String descricao;

    public Aquisicao(int id, String descricao)
    {
        this.id = id;
        this.descricao = descricao;
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
