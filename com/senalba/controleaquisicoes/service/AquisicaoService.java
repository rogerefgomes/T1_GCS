
package com.senalba.controleaquisicoes.service;

import com.senalba.controleaquisicoes.model.Aquisicao;

import java.util.ArrayList;
import java.util.List;

public class AquisicaoService
{
    private List<Aquisicao> aquisicoes = new ArrayList<>();

    public void adicionarAquisicao(Aquisicao aquisicao)
    {
        aquisicoes.add(aquisicao);
    }

    public void removerAquisicao(int idAquisicao)
    {
        aquisicoes.removeIf(a -> a.getId() == idAquisicao);
    }

    public List<Aquisicao> listarAquisicoes()
    {
        return new ArrayList<>(aquisicoes);
    }
}
