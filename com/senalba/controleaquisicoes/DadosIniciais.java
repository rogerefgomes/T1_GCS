
package com.senalba.controleaquisicoes;

import com.senalba.controleaquisicoes.model.Aquisicao;
import com.senalba.controleaquisicoes.model.Usuario;
import com.senalba.controleaquisicoes.service.AquisicaoService;
import com.senalba.controleaquisicoes.service.UsuarioService;

public class DadosIniciais {
    public static void inserirDadosIniciais() {
        UsuarioService usuarioService = new UsuarioService();
        usuarioService.login(new Usuario("Usuário Teste", "UT"));

        AquisicaoService aquisicaoService = new AquisicaoService();
        aquisicaoService.adicionarAquisicao(new Aquisicao(1, "Convenção Coletiva"));
        aquisicaoService.adicionarAquisicao(new Aquisicao(2, "Contribuição Espontânea"));
        // RG: Adicionar aqui mais aquisições se for preciso
    }
}

