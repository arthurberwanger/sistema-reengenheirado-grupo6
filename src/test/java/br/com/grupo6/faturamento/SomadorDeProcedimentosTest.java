package br.com.grupo6.faturamento;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SomadorDeProcedimentosTest {
    @Test
    public void somaOsValoresDosProcedimentos() {
        assertEquals(300.0,
                new SomadorDeProcedimentosPadrao().somar(new double[]{200.0, 100.0}),
                0.0);
    }

    @Test
    public void listaVaziaTemSubtotalZero() {
        assertEquals(0.0, new SomadorDeProcedimentosPadrao().somar(new double[0]), 0.0);
    }

    @Test
    public void rejeitaListaNula() {
        try {
            new SomadorDeProcedimentosPadrao().somar(null);
            fail("O somador deveria rejeitar lista nula.");
        } catch (IllegalArgumentException esperado) {
            assertEquals("A lista de procedimentos não pode ser nula.", esperado.getMessage());
        }
    }
}