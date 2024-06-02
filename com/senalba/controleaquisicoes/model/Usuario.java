
package com.senalba.controleaquisicoes.model;

public abstract class Usuario{
    private int ID;
    private String nome;
    private String iniciais;
    private String tipo;

    public Usuario(int ID, String nome, String iniciais, String tipo)
    {
        this.ID = ID;
        this.nome = nome;
        this.iniciais = iniciais;
        this.tipo = tipo;
    }

    public String getNome()
    {
        return nome;
    }

    public String getIniciais()
    {
        return iniciais;
    }
    public abstract String getTipo();
}
}
