package br.com.grupo6.faturamento;

public interface RegraDeCobranca {
    double aplicar(double subtotal, boolean cobrarTaxaAdministrativa);
}