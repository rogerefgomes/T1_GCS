
package com.senalba.controleaquisicoes.service;

import com.senalba.controleaquisicoes.model.Usuario;

public class UsuarioService
{
    private Usuario usuarioLogado;

    public void login(Usuario usuario)
    {
        usuarioLogado = usuario;
    }

    public Usuario getUsuarioLogado()
    {
        return usuarioLogado;
    }

    public void logout()
    {
        usuarioLogado = null;
    }
}

