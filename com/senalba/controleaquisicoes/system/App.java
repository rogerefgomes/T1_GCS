package com.senalba.controleaquisicoes.system;

import com.senalba.controleaquisicoes.user.Administrador;
import com.senalba.controleaquisicoes.user.Departamento;
import com.senalba.controleaquisicoes.user.Funcionario;
import com.senalba.controleaquisicoes.user.Usuario;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Usuario> usuarios;
    private List<Departamento> departamentos;

    public App() {
        this.usuarios = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        inicializarDados();
    }

  
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
