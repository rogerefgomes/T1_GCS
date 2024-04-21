
package com.senalba.controleaquisicoes.view;

import com.senalba.controleaquisicoes.model.Aquisicao;
import com.senalba.controleaquisicoes.service.AquisicaoService;

public class GerenciadorAquisicoes
{
    private AquisicaoService aquisicaoService = new AquisicaoService();

    public void adicionarAquisicao(int id, String descricao)
    {
        aquisicaoService.adicionarAquisicao(new Aquisicao(id, descricao));
    }

    public void removerAquisicao(int idAquisicao)
    {
        aquisicaoService.removerAquisicao(idAquisicao);
    }

    public void listarAquisicoes()
    {
        aquisicaoService.listarAquisicoes().forEach(a -> System.out.println(a.getId() + ": " + a.getDescricao()));
    }
}

