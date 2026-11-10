package br.com.grupo6.faturamento;

public class RegraParticular implements RegraDeCobranca {
    private static final double SUBTOTAL_MINIMO_PARA_DESCONTO = 500.0;
    private static final double PERCENTUAL_DESCONTO = 0.05;

    @Override
    public double aplicar(double subtotal, boolean cobrarTaxaAdministrativa) {
        if (subtotal > SUBTOTAL_MINIMO_PARA_DESCONTO) {
            return subtotal - (subtotal * PERCENTUAL_DESCONTO);
        }
        return subtotal;
    }
}