package com.SamuelMartins.domain.builder;

import com.SamuelMartins.domain.Conta;
import com.SamuelMartins.domain.Usuario;

public class ContaBuilder {
    private Long id;
    private String nome;
    private Usuario usuario;
    private ContaBuilder(){}

    public static ContaBuilder umaConta(){
        ContaBuilder builder = new ContaBuilder();
        inicializarDadosBuilder(builder);
        return builder;
    }

    public static void inicializarDadosBuilder(ContaBuilder builder){
        builder.id = 1l;
        builder.nome = "Conta Válida";
        builder.usuario = UsuarioBuilder.umUsuario().agora();
    }

    public  ContaBuilder comId(Long id){
        id = id;
        return this;
    }

    public  ContaBuilder comNome(String nome){
        nome = nome;
        return this;
    }

    public  ContaBuilder comUsuario(Usuario usuario){
        usuario = usuario;
        return this;
    }

    public Conta agora(){
        return  new Conta(id, nome, usuario);
    }
}


