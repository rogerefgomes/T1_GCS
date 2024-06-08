package com.senalba.controleaquisicoes.system;

import com.senalba.controleaquisicoes.acquisition.ItemPedido;
import com.senalba.controleaquisicoes.acquisition.PedidoAquisicao;
import com.senalba.controleaquisicoes.user.Administrador;
import com.senalba.controleaquisicoes.user.Departamento;
import com.senalba.controleaquisicoes.user.Funcionario;
import com.senalba.controleaquisicoes.user.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sistema {
    private List<Usuario> usuarios;
    private List<Departamento> departamentos;
    private List<PedidoAquisicao> pedidos;
    private Usuario usuarioAtual;

    public Sistema() {
        inicializarDados();
        this.pedidos = new ArrayList<>();
    }

    private void inicializarDados() {
        // Inicialização dos departamentos
        departamentos = new ArrayList<>();
        departamentos.add(new Departamento("Financeiro", 10000));
        departamentos.add(new Departamento("RH", 8000));
        departamentos.add(new Departamento("Engenharia", 15000));
        departamentos.add(new Departamento("Manutenção", 12000));
        departamentos.add(new Departamento("Marketing", 7000));

        // Inicialização dos usuários
        usuarios = new ArrayList<>();
        usuarios.add(new Funcionario("1", "Alice", departamentos.get(0)));
        usuarios.add(new Funcionario("2", "Bob", departamentos.get(1)));
        usuarios.add(new Funcionario("3", "Charlie", departamentos.get(2)));
        usuarios.add(new Funcionario("4", "David", departamentos.get(3)));
        usuarios.add(new Funcionario("5", "Eve", departamentos.get(4)));
        usuarios.add(new Funcionario("6", "Frank", departamentos.get(0)));
        usuarios.add(new Funcionario("7", "Grace", departamentos.get(1)));
        usuarios.add(new Funcionario("8", "Hank", departamentos.get(2)));
        usuarios.add(new Funcionario("9", "Ivy", departamentos.get(3)));
        usuarios.add(new Funcionario("10", "Jack", departamentos.get(4)));
        usuarios.add(new Funcionario("11", "Kim", departamentos.get(0)));
        usuarios.add(new Funcionario("12", "Leo", departamentos.get(1)));
        usuarios.add(new Funcionario("13", "Mia", departamentos.get(2)));
        usuarios.add(new Funcionario("14", "Nick", departamentos.get(3)));
        usuarios.add(new Funcionario("15", "Oscar", departamentos.get(4)));
        usuarios.add(new Administrador("16", "Admin1"));
        usuarios.add(new Administrador("17", "Admin2"));
    }

    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void escolherUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                usuarioAtual = usuario;
                System.out.println("Usuário atual: " + usuario);
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    public void registrarPedido(List<ItemPedido> itens, Usuario solicitante, Departamento departamento) {
        if (solicitante instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) solicitante;
            if (!funcionario.getDepartamento().equals(departamento)) {
                System.out.println("Funcionário não pertence ao departamento especificado.");
                return;
            }
        }

        PedidoAquisicao pedido = new PedidoAquisicao(solicitante, departamento, itens);
        if (pedido.getValorTotal() <= departamento.getLimitePorPedido()) {
            pedidos.add(pedido);
            System.out.println("Pedido registrado com sucesso.");
        } else {
            System.out.println("Valor do pedido excede o limite do departamento.");
        }
    }

    public void listarPedidosEntreDatas(Date inicio, Date fim) {
        boolean found = false;
        for (PedidoAquisicao pedido : pedidos) {
            if (!pedido.getDataPedido().before(inicio) && !pedido.getDataPedido().after(fim)) {
                System.out.println(pedido);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Nenhum pedido encontrado no intervalo de datas especificado.");
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

    public void aprovarRejeitarPedido(String idPedido, boolean aprovar) {
        for (PedidoAquisicao pedido : pedidos) {
            if (pedido.getIdPedido().equals(idPedido) && usuarioAtual instanceof Administrador) {
                if (aprovar) {
                    pedido.aprovar();
                    System.out.println("Pedido aprovado.");
                } else {
                    pedido.reprovar();
                    System.out.println("Pedido reprovado.");
                }
                return;
            }
        }
        System.out.println("Pedido não encontrado ou usuário não autorizado.");
    }

    public void visualizarEstatisticas() {
        // Implementar lógica de estatísticas
    }
}
