package com.senalba.controleaquisicoes.acquisition;

import com.senalba.controleaquisicoes.user.Departamento;
import com.senalba.controleaquisicoes.user.Funcionario;
import com.senalba.controleaquisicoes.user.Usuario;

import java.util.Date;
import java.util.List;

public class PedidoAquisicao {
    private Funcionario solicitante;
    private Departamento departamento;
    private Date dataPedido;
    private Date dataConclusao;
    private String status;
    private List<ItemPedido> itens;
    private String idPedido;

    public PedidoAquisicao(Funcionario solicitante, List<ItemPedido> itens, String idPedido) {
        this.solicitante = solicitante;
        this.departamento = solicitante.getDepartamento();
        this.dataPedido = new Date();
        this.status = "Aberto";
        this.itens = itens;
        this.idPedido = idPedido;
    }

    public PedidoAquisicao(Usuario solicitante2, Departamento departamento2, List<ItemPedido> itens2) {
        
    }

    public double getValorTotal() {
        return itens.stream().mapToDouble(ItemPedido::getTotal).sum();
    }

    public void aprovar() {
        if (this.status.equals("Aberto")) {
            this.status = "Aprovado";
        }
    }

    public void reprovar() {
        if (this.status.equals("Aberto")) {
            this.status = "Reprovado";
        }
    }

    public void concluir() {
        if (this.status.equals("Aprovado")) {
            this.status = "Concluído";
            this.dataConclusao = new Date();
        }
    }

    // Getters and Setters
    public Funcionario getSolicitante() {
        return solicitante;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public String getStatus() {
        return status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public String getidPedido() {
        return idPedido;
    }

}
