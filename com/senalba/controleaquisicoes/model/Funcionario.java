package com.senalba.controleaquisicoes.model;

import com.senalba.controleaquisicoes.model.Departamento;
import com.senalba.controleaquisicoes.model.Usuario;

public class Funcionario extends Usuario {
    private Departamento departamento;

    public Funcionario(String id, String nome, Departamento departamento) {
        super(id, nome);
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public String getTipo() {
        return "Funcionario";
    }
}
