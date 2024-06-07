package com.senalba.controleaquisicoes;

import com.senalba.controleaquisicoes.acquisition.ItemPedido;
import com.senalba.controleaquisicoes.system.Sistema;
import com.senalba.controleaquisicoes.user.Administrador;
import com.senalba.controleaquisicoes.user.Departamento;
import com.senalba.controleaquisicoes.user.Funcionario;
import com.senalba.controleaquisicoes.user.Usuario;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menu:");
            System.out.println("1. Escolher Usuário");
            System.out.println("2. Registrar Pedido");
            System.out.println("3. Listar Pedidos entre Datas");
            System.out.println("4. Buscar Pedidos por Funcionário");
            System.out.println("5. Buscar Pedidos por Descrição de Item");
            System.out.println("6. Aprovar/Rejeitar Pedido");
            System.out.println("7. Visualizar Estatísticas");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do usuário: ");
                    String userId = scanner.nextLine();
                    sistema.escolherUsuario(userId);
                    break;
                case 2:
                    if (sistema.getUsuarioAtual() != null) {
                        Usuario solicitante = sistema.getUsuarioAtual();
                        Departamento departamentoSolicitante = null;
                        if (solicitante instanceof Funcionario) {
                            Funcionario funcionario = (Funcionario) solicitante;
                            departamentoSolicitante = funcionario.getDepartamento();
                        } else if (solicitante instanceof Administrador) {
                            System.out.println("Selecione o departamento para o pedido:");
                            for (int i = 0; i < sistema.getDepartamentos().size(); i++) {
                                System.out.println((i + 1) + ". " + sistema.getDepartamentos().get(i).getNome());
                            }
                            int deptoIndex = scanner.nextInt() - 1;
                            scanner.nextLine();  // Consumir nova linha
                            if (deptoIndex >= 0 && deptoIndex < sistema.getDepartamentos().size()) {
                                departamentoSolicitante = sistema.getDepartamentos().get(deptoIndex);
                            } else {
                                System.out.println("Departamento inválido.");
                                break;
                            }
                        }

                        if (departamentoSolicitante != null) {
                            List<ItemPedido> itens = new ArrayList<>();
                            String descricao;
                            double valorUnitario;
                            int quantidade;

                            while (true) {
                                System.out.print("Digite a descrição do item (ou 'sair' para terminar): ");
                                descricao = scanner.nextLine();
                                if (descricao.equalsIgnoreCase("sair")) break;

                                System.out.print("Digite o valor unitário do item: ");
                                valorUnitario = scanner.nextDouble();
                                System.out.print("Digite a quantidade do item: ");
                                quantidade = scanner.nextInt();
                                scanner.nextLine();  // Consumir nova linha

                                itens.add(new ItemPedido(descricao, valorUnitario, quantidade));
                            }

                            // Valida se o valor total do pedido é menor ou igual ao limite do departamento
                            double valorTotal = 0;
                            for (ItemPedido item : itens) {
                                valorTotal += item.getValorTotal();
                            }

                            if (valorTotal <= departamentoSolicitante.getLimitePorPedido()) {
                                sistema.registrarPedido(itens, solicitante, departamentoSolicitante);
                            } else {
                                System.out.println("Valor do pedido excede o limite do departamento.");
                            }
                        } else {
                            System.out.println("Departamento inválido.");
                        }
                    } else {
                        System.out.println("Nenhum usuário selecionado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a data de início (yyyy-mm-dd): ");
                    Date dataInicio = java.sql.Date.valueOf(scanner.nextLine());
                    System.out.print("Digite a data de fim (yyyy-mm-dd): ");
                    Date dataFim = java.sql.Date.valueOf(scanner.nextLine());
                    sistema.listarPedidosEntreDatas(dataInicio, dataFim);
                    break;
                case 4:
                    System.out.print("Digite o ID do funcionário: ");
                    String funcionarioId = scanner.nextLine();
                    sistema.buscarPedidosPorFuncionario(funcionarioId);
                    break;
                case 5:
                    System.out.print("Digite a descrição do item: ");
                    String descricaoItem = scanner.nextLine();
                    sistema.buscarPedidosPorDescricaoItem(descricaoItem);
                    break;
                case 6:
                    if (sistema.getUsuarioAtual() instanceof Administrador) {
                        System.out.print("Digite o ID do pedido: ");
                        int pedidoId = scanner.nextInt();
                        System.out.print("Digite 1 para aprovar ou 0 para rejeitar: ");
                        boolean aprovar = scanner.nextInt() == 1;
                        sistema.aprovarRejeitarPedido(pedidoId, aprovar);
                    } else {
                        System.out.println("Somente administradores podem aprovar ou rejeitar pedidos.");
                    }
                    break;
                case 7:
                    sistema.visualizarEstatisticas();
                    break;
                case 8:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (opcao != 8) {
                System.out.println("Pressione Enter para voltar ao menu principal...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
