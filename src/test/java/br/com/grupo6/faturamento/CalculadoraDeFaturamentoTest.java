package br.com.grupo6.faturamento;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CalculadoraDeFaturamentoTest {
    @Test
    public void exemploLegadoContinuaRetornando279E50() {
        CalculadoraDeFaturamento calculadora = new CalculadoraDeFaturamento(
                new SomadorDeProcedimentosPadrao(),
                new FabricaDeRegraDeCobrancaPadrao());

        assertEquals(279.5, calculadora.calcularValorFinal(
                TipoConsulta.aPartirDoCodigoLegado(1),
                new double[]{200.0, 100.0},
                true), 0.0);
    }

    @Test
    public void dependenciasPodemSerSubstituidas() {
        SomadorDeProcedimentos somadorFalso = procedimentos -> 123.0;
        FabricaDeRegraDeCobranca fabricaFalsa = tipoConsulta -> (subtotal, taxa) -> subtotal + 10.0;
        CalculadoraDeFaturamento calculadora = new CalculadoraDeFaturamento(somadorFalso, fabricaFalsa);

        assertEquals(133.0, calculadora.calcularValorFinal(
                TipoConsulta.PARTICULAR, new double[]{1.0}, false), 0.0);
    }

    @Test
    public void rejeitaSomadorNulo() {
        try {
            new CalculadoraDeFaturamento(null, new FabricaDeRegraDeCobrancaPadrao());
            fail("A calculadora deveria rejeitar somador nulo.");
        } catch (IllegalArgumentException esperado) {
            assertEquals("O somador de procedimentos não pode ser nulo.", esperado.getMessage());
        }
    }

    @Test
    public void rejeitaFabricaNula() {
        try {
            new CalculadoraDeFaturamento(new SomadorDeProcedimentosPadrao(), null);
            fail("A calculadora deveria rejeitar fábrica nula.");
        } catch (IllegalArgumentException esperado) {
            assertEquals("A fábrica de regras não pode ser nula.", esperado.getMessage());
        }
    }

    @Test
    public void rejeitaTipoNulo() {
        CalculadoraDeFaturamento calculadora = new CalculadoraDeFaturamento(
                new SomadorDeProcedimentosPadrao(), new FabricaDeRegraDeCobrancaPadrao());
        try {
            calculadora.calcularValorFinal(null, new double[]{100.0}, false);
            fail("A calculadora deveria rejeitar tipo nulo.");
        } catch (IllegalArgumentException esperado) {
            assertEquals("O tipo de consulta não pode ser nulo.", esperado.getMessage());
        }
    }

    @Test
    public void rejeitaListaDeProcedimentosNula() {
        CalculadoraDeFaturamento calculadora = new CalculadoraDeFaturamento(
                new SomadorDeProcedimentosPadrao(), new FabricaDeRegraDeCobrancaPadrao());
        try {
            calculadora.calcularValorFinal(TipoConsulta.CONVENIO, null, false);
            fail("A calculadora deveria rejeitar lista nula.");
        } catch (IllegalArgumentException esperado) {
            assertEquals("A lista de procedimentos não pode ser nula.", esperado.getMessage());
        }
    }
}