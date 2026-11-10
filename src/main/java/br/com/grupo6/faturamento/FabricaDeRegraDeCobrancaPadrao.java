package br.com.grupo6.faturamento;

public class FabricaDeRegraDeCobrancaPadrao implements FabricaDeRegraDeCobranca {
    @Override
    public RegraDeCobranca criar(TipoConsulta tipoConsulta) {
        if (tipoConsulta == null) {
            throw new IllegalArgumentException("O tipo de consulta não pode ser nulo.");
        }

        switch (tipoConsulta) {
            case CONVENIO:
                return new RegraConvenio();
            case PARTICULAR:
                return new RegraParticular();
            case SEM_REGRA:
            default:
                return new RegraSemDesconto();
        }
    }
}