package br.com.grupo6.faturamento;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegrasDeCobrancaTest {
    @Test
    public void convenioAplicaDescontoETaxaQuandoSolicitada() {
        assertEquals(279.5, new RegraConvenio().aplicar(300.0, true), 0.0);
    }

    @Test
    public void convenioAplicaDescontoSemTaxaQuandoNaoSolicitada() {
        assertEquals(264.0, new RegraConvenio().aplicar(300.0, false), 0.0);
    }

    @Test
    public void particularAplicaDescontoAcimaDeQuinhentos() {
        assertEquals(570.0, new RegraParticular().aplicar(600.0, false), 0.0);
    }

    @Test
    public void particularNaoAplicaDescontoNoLimite() {
        assertEquals(500.0, new RegraParticular().aplicar(500.0, false), 0.0);
    }

    @Test
    public void particularNaoAplicaDescontoAbaixoDoLimite() {
        assertEquals(499.0, new RegraParticular().aplicar(499.0, false), 0.0);
    }

    @Test
    public void tipoSemRegraMantemSubtotal() {
        assertEquals(300.0, new RegraSemDesconto().aplicar(300.0, true), 0.0);
    }
}