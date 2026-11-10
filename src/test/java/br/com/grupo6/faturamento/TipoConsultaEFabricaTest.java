package br.com.grupo6.faturamento;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TipoConsultaEFabricaTest {
    @Test
    public void converteCodigosLegadosConhecidosEDesconhecidos() {
        assertEquals(TipoConsulta.CONVENIO, TipoConsulta.aPartirDoCodigoLegado(1));
        assertEquals(TipoConsulta.PARTICULAR, TipoConsulta.aPartirDoCodigoLegado(2));
        assertEquals(TipoConsulta.SEM_REGRA, TipoConsulta.aPartirDoCodigoLegado(99));
        assertEquals(1, TipoConsulta.CONVENIO.getCodigoLegado());
    }

    @Test
    public void fabricaSelecionaEstrategiaDeCadaTipo() {
        FabricaDeRegraDeCobranca fabrica = new FabricaDeRegraDeCobrancaPadrao();
        assertTrue(fabrica.criar(TipoConsulta.CONVENIO) instanceof RegraConvenio);
        assertTrue(fabrica.criar(TipoConsulta.PARTICULAR) instanceof RegraParticular);
        assertTrue(fabrica.criar(TipoConsulta.SEM_REGRA) instanceof RegraSemDesconto);
    }

    @Test
    public void fabricaRejeitaTipoNulo() {
        try {
            new FabricaDeRegraDeCobrancaPadrao().criar(null);
            fail("A fábrica deveria rejeitar tipo nulo.");
        } catch (IllegalArgumentException esperado) {
            assertEquals("O tipo de consulta não pode ser nulo.", esperado.getMessage());
        }
    }
}