package br.com.grupo6.faturamento;

public class RegraConvenio implements RegraDeCobranca {
    private static final double PERCENTUAL_DESCONTO = 0.12;
    private static final double TAXA_ADMINISTRATIVA = 15.50;

    @Override
    public double aplicar(double subtotal, boolean cobrarTaxaAdministrativa) {
        double valorFinal = subtotal - (subtotal * PERCENTUAL_DESCONTO);
        if (cobrarTaxaAdministrativa) {
            valorFinal += TAXA_ADMINISTRATIVA;
        }
        return valorFinal;
    }
}