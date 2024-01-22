package com.SamuelMartins.domain;

import com.SamuelMartins.domain.builder.ContaBuilder;
import com.SamuelMartins.domain.builder.UsuarioBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaTest {

    @Test
    public void deveCriarContaValida(){
        //CriarConta
        Conta conta = ContaBuilder.umaConta().agora();
        //Assertions em cima da conta
        Assertions.assertAll("Conta",
                () -> Assertions.assertEquals(1L, conta.id()),
                () ->  Assertions.assertEquals("Conta Válida",  conta.nome()),
                () -> Assertions.assertEquals(UsuarioBuilder.umUsuario().agora(), conta.usuario())
        );

    }
}
