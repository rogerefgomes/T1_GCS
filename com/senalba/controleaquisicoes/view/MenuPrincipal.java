
package com.senalba.controleaquisicoes.view;

import com.senalba.controleaquisicoes.model.Usuario;
import com.senalba.controleaquisicoes.service.UsuarioService;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);
    private UsuarioService usuarioService = new UsuarioService();

    public void exibirMenu() {
        System.out.println("Bem-vindo ao Sistema de Controle de Aquisições");
        System.out.println("1. Realizar login");
        System.out.println("2. Alterar usuário logado");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                realizarLogin();
                break;
            case 2:
                alterarUsuarioLogado();
                break;
            case 3:
                System.out.println("Saindo do sistema...");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private void realizarLogin() {
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.next();
        System.out.print("Digite as iniciais do usuário: ");
        String iniciaisUsuario = scanner.next();

        Usuario usuario = new Usuario(nomeUsuario, iniciaisUsuario);
        usuarioService.login(usuario);
        System.out.println("Login realizado com sucesso!");
    }

    private void alterarUsuarioLogado() {
        System.out.print("Digite o nome do novo usuário: ");
        String nomeUsuario = scanner.next();
        System.out.print("Digite as iniciais do novo usuário: ");
        String iniciaisUsuario = scanner.next();

        Usuario novoUsuario = new Usuario(nomeUsuario, iniciaisUsuario);
        usuarioService.login(novoUsuario);
        System.out.println("Usuário alterado com sucesso!");
    }
}


