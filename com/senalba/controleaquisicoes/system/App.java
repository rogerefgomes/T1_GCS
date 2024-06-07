package com.senalba.controleaquisicoes.system;

import com.senalba.controleaquisicoes.user.Administrador;
import com.senalba.controleaquisicoes.user.Departamento;
import com.senalba.controleaquisicoes.user.Funcionario;
import com.senalba.controleaquisicoes.user.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Usuario> usuarios;
    private List<Departamento> departamentos;

    public App() {
        this.usuarios = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        inicializarDados();
    }

    public void inicializarDados() {
        // Adicionar departamentos
        departamentos.add(new Departamento("Financeiro", 5000.0));
        departamentos.add(new Departamento("RH", 3000.0));
        departamentos.add(new Departamento("Engenharia", 10000.0));
        departamentos.add(new Departamento("Manutenção", 4000.0));
        departamentos.add(new Departamento("TI", 7000.0));

        // Adicionar funcionários e administradores
        Departamento financeiro = departamentos.get(0);
        Departamento rh = departamentos.get(1);
        Departamento engenharia = departamentos.get(2);
        Departamento manutencao = departamentos.get(3);
        Departamento ti = departamentos.get(4);

        usuarios.add(new Funcionario("F1", "Carlos Silva", financeiro));
        usuarios.add(new Funcionario("F2", "Maria Souza", rh));
        usuarios.add(new Funcionario("F3", "João Oliveira", engenharia));
        usuarios.add(new Funcionario("F4", "Ana Costa", manutencao));
        usuarios.add(new Funcionario("F5", "Luiz Lima", ti));
        usuarios.add(new Funcionario("F6", "Pedro Santos", financeiro));
        usuarios.add(new Funcionario("F7", "Mariana Almeida", rh));
        usuarios.add(new Funcionario("F8", "Rafael Torres", engenharia));
        usuarios.add(new Funcionario("F9", "Juliana Fernandes", manutencao));
        usuarios.add(new Funcionario("F10", "Thiago Silva", ti));
        usuarios.add(new Funcionario("F11", "André Rocha", financeiro));
        usuarios.add(new Funcionario("F12", "Carla Menezes", rh));
        usuarios.add(new Funcionario("F13", "Gustavo Azevedo", engenharia));
        usuarios.add(new Funcionario("F14", "Fernanda Costa", manutencao));
        usuarios.add(new Funcionario("F15", "Paulo Gomes", ti));

        usuarios.add(new Administrador("A1", "Admin1"));
        usuarios.add(new Administrador("A2", "Admin2"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
