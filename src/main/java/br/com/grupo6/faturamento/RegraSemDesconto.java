package br.com.grupo6.faturamento;

public class RegraSemDesconto implements RegraDeCobranca {
    @Override
    public double aplicar(double subtotal, boolean cobrarTaxaAdministrativa) {
        return subtotal;
    }
}