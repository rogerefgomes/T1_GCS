package com.senalba.controleaquisicoes.model;

import com.senalba.controleaquisicoes.model.Usuario;

public class Administrador extends Usuario {
    public Administrador(String id, String nome) {
        super(id, nome);
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}
