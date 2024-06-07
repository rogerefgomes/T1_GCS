package com.senalba.controleaquisicoes.system;

import com.senalba.controleaquisicoes.acquisition.ItemPedido;
import com.senalba.controleaquisicoes.acquisition.PedidoAquisicao;
import com.senalba.controleaquisicoes.user.Administrador;
import com.senalba.controleaquisicoes.user.Departamento;
import com.senalba.controleaquisicoes.user.Funcionario;
import com.senalba.controleaquisicoes.user.Usuario;

import java.util.*;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Departamento> departamentos;
    private List<PedidoAquisicao> pedidos;
    private Usuario usuarioAtual;

    public Sistema(List<Usuario> usuarios, List<Departamento> departamentos) {
        this.usuarios = usuarios;
        this.departamentos = departamentos;
        this.pedidos = new ArrayList<>();
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

        usuarios.add(new Funcionario("F112230", "Carlos Silva", financeiro));
        usuarios.add(new Funcionario("F112231", "Maria Souza", rh));
        usuarios.add(new Funcionario("F112232", "João Oliveira", engenharia));
        usuarios.add(new Funcionario("F112233", "Ana Costa", manutencao));
        usuarios.add(new Funcionario("F112234", "Luiz Lima", ti));
        usuarios.add(new Funcionario("F112235", "Pedro Santos", financeiro));
        usuarios.add(new Funcionario("F112236", "Mariana Almeida", rh));
        usuarios.add(new Funcionario("F112237", "Rafael Torres", engenharia));
        usuarios.add(new Funcionario("F112238", "Juliana Fernandes", manutencao));
        usuarios.add(new Funcionario("F112239", "Thiago Silva", ti));
        usuarios.add(new Funcionario("F112240", "André Rocha", financeiro));
        usuarios.add(new Funcionario("F112241", "Carla Menezes", rh));
        usuarios.add(new Funcionario("F112242", "Gustavo Azevedo", engenharia));
        usuarios.add(new Funcionario("F112243", "Fernanda Costa", manutencao));
        usuarios.add(new Funcionario("F112244", "Paulo Gomes", ti));

        usuarios.add(new Administrador("A101120", "Ademir Silva"));
        usuarios.add(new Administrador("A101121", "Marcelo Fontes"));
        usuarios.add(new Administrador("A101122", "Gabriela Tebet"));

    }

    public void escolherUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuarioAtual = usuario;
                System.out.println("Usuário atual: " + usuario.getNome());
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void registrarPedido(List<ItemPedido> itens) {
        if (usuarioAtual instanceof Funcionario) {
            PedidoAquisicao pedido = new PedidoAquisicao((Funcionario) usuarioAtual, itens);
            if (pedido.getValorTotal() <= pedido.getDepartamento().getLimitePorPedido()) {
                pedidos.add(pedido);
                System.out.println("Pedido registrado com sucesso.");
            } else {
                System.out.println("Valor do pedido excede o limite do departamento.");
            }
        } else {
            System.out.println("Somente funcionários podem registrar pedidos.");
        }
    }

    public void listarPedidosEntreDatas(Date inicio, Date fim) {
        for (PedidoAquisicao pedido : pedidos) {
            if (!pedido.getDataPedido().before(inicio) && !pedido.getDataPedido().after(fim)) {
                System.out.println(pedido);
            }
        }
    }

    public void buscarPedidosPorFuncionario(String idFuncionario) {
        for (PedidoAquisicao pedido : pedidos) {
            if (pedido.getSolicitante().getId().equals(idFuncionario)) {
                System.out.println(pedido);
            }
        }
    }

    public void buscarPedidosPorDescricaoItem(String descricao) {
        for (PedidoAquisicao pedido : pedidos) {
            for (ItemPedido item : pedido.getItens()) {
                if (item.getDescricao().contains(descricao)) {
                    System.out.println(pedido);
                    break;
                }
            }
        }
    }

//    public void aprovarRejeitarPedido(int idPedido, boolean aprovar) {
//        for (PedidoAquisicao pedido : pedidos) {
//            if (pedido.getId() == idPedido && usuarioAtual instanceof Administrador) {
//                if (aprovar) {
//                    pedido.aprovar();
//                    System.out.println("Pedido aprovado.");
//                } else {
//                    pedido.reprovar();
//                    System.out.println("Pedido reprovado.");
//                }
//                return;
//            }
//        }
//        System.out.println("Pedido não encontrado ou usuário não autorizado.");
//    }

    public void visualizarEstatisticas() {
        int totalAprovados = 0;
        int totalReprovados = 0;
        double valorTotal = 0;
        int totalPedidos = 0;
        Date agora = new Date();
        long umMesAtras = agora.getTime() - (30L * 24 * 60 * 60 * 1000);
        Date umMesAtrasData = new Date(umMesAtras);

        for (PedidoAquisicao pedido : pedidos) {
            if (pedido.getStatus().equals("Aprovado")) {
                totalAprovados++;
            } else if (pedido.getStatus().equals("Reprovado")) {
                totalReprovados++;
            }

            if (!pedido.getDataPedido().before(umMesAtrasData)) {
                valorTotal += pedido.getValorTotal();
                totalPedidos++;
            }
        }

        double percentualAprovados = totalAprovados * 100.0 / (totalAprovados + totalReprovados);
        double percentualReprovados = totalReprovados * 100.0 / (totalAprovados + totalReprovados);
        double valorMedio = totalPedidos > 0 ? valorTotal / totalPedidos : 0;

        System.out.println("Estatísticas:");
        System.out.println("Total de pedidos: " + (totalAprovados + totalReprovados));
        System.out.println("Aprovados: " + totalAprovados + " (" + percentualAprovados + "%)");
        System.out.println("Reprovados: " + totalReprovados + " (" + percentualReprovados + "%)");
        System.out.println("Pedidos nos últimos 30 dias: " + totalPedidos);
        System.out.println("Valor médio dos pedidos nos últimos 30 dias: " + valorMedio);
    }
}
