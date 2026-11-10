package br.com.grupo6.faturamento;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void imprimeResultadoDeReferenciaDoLegado() throws Exception {
        PrintStream saidaOriginal = System.out;
        ByteArrayOutputStream captura = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(captura, true, "UTF-8"));
            Main.main(new String[0]);
        } finally {
            System.setOut(saidaOriginal);
        }
        assertEquals("279.5", new String(captura.toByteArray(), StandardCharsets.UTF_8).trim());
    }
}