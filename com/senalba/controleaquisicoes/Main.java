package com.senalba.controleaquisicoes;

import com.senalba.controleaquisicoes.acquisition.ItemPedido;
import com.senalba.controleaquisicoes.system.App;
import com.senalba.controleaquisicoes.system.Sistema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicializar o aplicativo e os dados
        App app = new App();
        Sistema sistema = new Sistema(app.getUsuarios(), app.getDepartamentos());

        // Selecionar usuário atual
        sistema.escolherUsuario("F1");

        // Criar e registrar um pedido de aquisição
        List<ItemPedido> itens = new ArrayList<>();
        itens.add(new ItemPedido("Notebook", 1500.0, 2));
        itens.add(new ItemPedido("Mouse", 50.0, 5));

        sistema.registrarPedido(itens);

        // Exibir estatísticas
        sistema.visualizarEstatisticas();

        // Buscar pedido
        sistema.buscarPedidosPorDescricaoItem("Monitor");

        // Buscar por funcionario
        sistema.buscarPedidosPorFuncionario("F2");

        // Listar pedidos por datas
        Date inicio = new Date(124,5,8);
        Date fim = new Date(124,6,8);
        sistema.listarPedidosEntreDatas(inicio,fim);

        // Aprovar ou negar pedidos
        sistema.aprovarRejeitarPedido(12345, true);
        sistema.aprovarRejeitarPedido(54321, false);
    }
}




