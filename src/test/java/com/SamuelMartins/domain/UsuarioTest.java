package com.SamuelMartins.domain;

import com.SamuelMartins.domain.builder.UsuarioBuilder;
import static com.SamuelMartins.domain.builder.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.*;

import com.SamuelMartins.domain.exception.ValidationException;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
import java.awt.image.CropImageFilter;

public class UsuarioTest {

    @Test
    public void deveCriarUsuarioValido(){
        Usuario usuario = umUsuario().agora();
        Assertions.assertAll("Usuario",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Usuário Válido", usuario.getNome()),
                () -> assertEquals("user@email.com", usuario.getEmail()),
                () -> assertEquals("123", usuario.getSenha())
        );
    }

    @Test
    public void deveRejeitarUsuarioSemNome(){
        ValidationException  e = Assertions.assertThrows(ValidationException.class, () -> {
            umUsuario().comNome(null).agora();
        });
        assertEquals("Nome é obrigatório",e.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemEmail(){
        ValidationException  e = Assertions.assertThrows(ValidationException.class, () -> {
            umUsuario().comEmail(null).agora();
        });
        assertEquals("email é obrigatório",e.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemSenha(){
        ValidationException  e = Assertions.assertThrows(ValidationException.class, () -> {
            umUsuario().comSenha(null).agora();
        });
        assertEquals("senha é obrigatório",e.getMessage());
    }


    //####CSV SOURCE

   /* @ParameterizedTest(name = "{4}")
    @CsvSource(value = {
            "1, null, '@email', '123', 'Nome é obrigatório'",
            "1, 'user', null, '123', 'email é obrigatório'",
            "1, 'user', '@email', null, 'senha é obrigatório'"
    }, nullValues = {"null"})*/



    /* #### Não ultiliza header####*/
    //@ParameterizedTest(name = "[{index}] - {4}")
    //@CsvFileSource(resources = "/UsuarioValidos.csv", numLinesToSkip = 1, nullValues = {"null"})

    @ParameterizedTest
    @CsvFileSource(resources = "/UsuarioValidos.csv", nullValues = {"null"} , useHeadersInDisplayName = true)

    public void deveValidarTodosCampos( Long id, String name, String email, String password, String mensagem){
        ValidationException e = assertThrows( ValidationException.class, () ->
                umUsuario()
                        .comId(id)
                        .comNome(name)
                        .comEmail(email)
                        .comSenha(password).agora()
        );
        assertEquals(mensagem, e.getMessage());
    }




}
