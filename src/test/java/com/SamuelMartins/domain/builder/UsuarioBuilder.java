package com.SamuelMartins.domain.builder;

import com.SamuelMartins.domain.Usuario;

public class UsuarioBuilder {
    private  Long id;
    private String nome;
    private String email;
    private String senha;
    private UsuarioBuilder(){}

    public static UsuarioBuilder umUsuario(){
        UsuarioBuilder builder = new UsuarioBuilder();
        inicializarDadosPadroes(builder);
        return builder; 
    }

    private static void inicializarDadosPadroes(UsuarioBuilder builder) {
        builder.id = 1L;
        builder.nome = "Usuário Válido";
        builder.email = "user@email.com";
        builder.senha = "123";
    }

    public UsuarioBuilder comId(Long param){
        id = param;
        return this;
    }

    public UsuarioBuilder comNome(String param){
        nome = param;
        return this;
    }

    public UsuarioBuilder comEmail(String param){
        email = param;
        return this;
    }

    public UsuarioBuilder comSenha(String param){
        senha = param;
        return this;
    }

    public Usuario agora(){
        return  new Usuario(id, nome, email, senha);
    }


}
