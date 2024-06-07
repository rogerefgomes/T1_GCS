package com.senalba.controleaquisicoes.user;

public abstract class Usuario {
    private String id;
    private String nome;
    private String iniciais;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
        this.iniciais = getIniciais(nome);
    }

    private String getIniciais(String nome) {
        String[] palavras = nome.split(" ");
        StringBuilder iniciais = new StringBuilder();
        for (String palavra : palavras) {
            iniciais.append(palavra.charAt(0));
        }
        return iniciais.toString();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIniciais() {
        return iniciais;
    }

    public abstract String getTipo();

    public String toString(){
        return "\nBem-vindo!" + 
            "\nUsuário atual: " +getNome()+
            "\nID: " +getId()+
            "\nIniciais: " +getIniciais()+
            "\nTipo: " +getTipo();
    }
}
