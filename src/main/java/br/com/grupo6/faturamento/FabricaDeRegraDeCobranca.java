package br.com.grupo6.faturamento;

public interface FabricaDeRegraDeCobranca {
    RegraDeCobranca criar(TipoConsulta tipoConsulta);
}