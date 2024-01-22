package com.SamuelMartins.domain;

import com.SamuelMartins.domain.exception.ValidationException;

import java.util.Objects;

public class Usuario {
    private  Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(Long id, String nome, String email, String senha) {
        if(nome == null) throw new ValidationException("Nome é obrigatório");
        if(email == null) throw new ValidationException("email é obrigatório");
        if(senha == null) throw new ValidationException("senha é obrigatório");

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!Objects.equals(nome, usuario.nome)) return false;
        if (!Objects.equals(email, usuario.email)) return false;
        return Objects.equals(senha, usuario.senha);
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        return result;
    }
}


