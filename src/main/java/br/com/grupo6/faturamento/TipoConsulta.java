package br.com.grupo6.faturamento;

public enum TipoConsulta {
    CONVENIO(1),
    PARTICULAR(2),
    SEM_REGRA(0);

    private final int codigoLegado;

    TipoConsulta(int codigoLegado) {
        this.codigoLegado = codigoLegado;
    }

    public int getCodigoLegado() {
        return codigoLegado;
    }

    public static TipoConsulta aPartirDoCodigoLegado(int codigoLegado) {
        for (TipoConsulta tipoConsulta : values()) {
            if (tipoConsulta.codigoLegado == codigoLegado && tipoConsulta != SEM_REGRA) {
                return tipoConsulta;
            }
        }
        return SEM_REGRA;
    }
}