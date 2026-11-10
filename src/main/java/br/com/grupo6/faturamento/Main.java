package br.com.grupo6.faturamento;

public class Main {
    private static final double VALOR_ESPERADO_DO_EXEMPLO = 279.5;

    public static void main(String[] args) {
        CalculadoraDeFaturamento calculadora = new CalculadoraDeFaturamento(
                new SomadorDeProcedimentosPadrao(),
                new FabricaDeRegraDeCobrancaPadrao());

        double valorFinal = calculadora.calcularValorFinal(
                TipoConsulta.aPartirDoCodigoLegado(1),
                new double[]{200.0, 100.0},
                true);

        if (Double.compare(valorFinal, VALOR_ESPERADO_DO_EXEMPLO) != 0) {
            throw new IllegalStateException("O resultado do exemplo não corresponde ao comportamento legado.");
        }
        System.out.println(valorFinal);
    }
}