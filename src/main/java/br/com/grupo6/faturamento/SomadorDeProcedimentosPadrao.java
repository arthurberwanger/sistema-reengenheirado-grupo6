package br.com.grupo6.faturamento;

public class SomadorDeProcedimentosPadrao implements SomadorDeProcedimentos {
    @Override
    public double somar(double[] procedimentosRealizados) {
        if (procedimentosRealizados == null) {
            throw new IllegalArgumentException("A lista de procedimentos não pode ser nula.");
        }

        double subtotal = 0.0;
        for (double valorProcedimento : procedimentosRealizados) {
            subtotal += valorProcedimento;
        }
        return subtotal;
    }
}