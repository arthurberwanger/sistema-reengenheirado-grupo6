package br.com.grupo6.faturamento;

public class CalculadoraDeFaturamento {
    private final SomadorDeProcedimentos somadorDeProcedimentos;
    private final FabricaDeRegraDeCobranca fabricaDeRegraDeCobranca;

    public CalculadoraDeFaturamento(
            SomadorDeProcedimentos somadorDeProcedimentos,
            FabricaDeRegraDeCobranca fabricaDeRegraDeCobranca) {
        if (somadorDeProcedimentos == null) {
            throw new IllegalArgumentException("O somador de procedimentos não pode ser nulo.");
        }
        if (fabricaDeRegraDeCobranca == null) {
            throw new IllegalArgumentException("A fábrica de regras não pode ser nula.");
        }
        this.somadorDeProcedimentos = somadorDeProcedimentos;
        this.fabricaDeRegraDeCobranca = fabricaDeRegraDeCobranca;
    }

    public double calcularValorFinal(
            TipoConsulta tipoConsulta,
            double[] procedimentosRealizados,
            boolean cobrarTaxaAdministrativa) {
        if (tipoConsulta == null) {
            throw new IllegalArgumentException("O tipo de consulta não pode ser nulo.");
        }

        double subtotal = somadorDeProcedimentos.somar(procedimentosRealizados);
        RegraDeCobranca regraDeCobranca = fabricaDeRegraDeCobranca.criar(tipoConsulta);
        return regraDeCobranca.aplicar(subtotal, cobrarTaxaAdministrativa);
    }
}