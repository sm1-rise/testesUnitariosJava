package com.SamuelMartins.domain;

import com.SamuelMartins.domain.exception.ValidationException;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void deveCriarUsuarioValido(){
        Usuario usuario = new Usuario(1L, "Usuario Valido", "user@email.com", "12345");
        Assertions.assertAll("Usuario",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Usuario Valido", usuario.getNome()),
                () -> assertEquals("user@email.com", usuario.getEmail()),
                () -> assertEquals("12345", usuario.getSenha())
        );
    }

    @Test
    public void deveRejeitarUsuarioSemNome(){
        ValidationException  e = Assertions.assertThrows(ValidationException.class, () -> {
            new Usuario (1L, null, "email@usuario.com", "123");
        });
        assertEquals("Pedro",e.getMessage());

    }
}
