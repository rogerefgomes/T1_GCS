
package com.senalba.controleaquisicoes.model;

public class Usuario
{
    private String nome;
    private String iniciais;

    public Usuario(String nome, String iniciais)
    {
        this.nome = nome;
        this.iniciais = iniciais;
    }

    public String getNome()
    {
        return nome;
    }

    public String getIniciais()
    {
        return iniciais;
    }
}
