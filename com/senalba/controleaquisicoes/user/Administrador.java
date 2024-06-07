package com.senalba.controleaquisicoes.user;

public class Administrador extends Usuario {
    public Administrador(String id, String nome) {
        super(id, nome);
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
