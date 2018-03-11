package processos.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RedesController {

    private InputStreamReader readerFromInputStream(InputStream entrada) {
        InputStream fluxo = entrada;
        InputStreamReader leitor = new InputStreamReader(fluxo);
        return leitor;
    }

    public String ip(String soName) {
        if (!soName.equalsIgnoreCase("Linux"))
            return null;
        Process processo;
        StringBuffer buffer = new StringBuffer();
        buffer.append("ifconfig");
        StringBuilder adaptador;
        List<String> adaptadoresList = new ArrayList<>();
        try {
            processo = Runtime.getRuntime().exec(buffer.toString());
            BufferedReader retornoProcesso = new BufferedReader(readerFromInputStream(processo.getInputStream()));
            adaptador = new StringBuilder();
            String linhaBuffer = retornoProcesso.readLine();
            while (linhaBuffer != null) {
                if (linhaBuffer.equals("")) {
                    adaptadoresList.add(adaptador.toString());
                    adaptador = new StringBuilder();
                }
                adaptador.append(String.format("%s \n", linhaBuffer));
                linhaBuffer = retornoProcesso.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        adaptador = new StringBuilder();
        for (String adap : adaptadoresList) {
            if (adap.contains("(Ethernet)") && adap.contains("inet")) {
                String nomeAdaptador = adap.substring(0, 8);
                int indexIp = adap.indexOf("inet");
                String ip = adap.substring(indexIp + 5, indexIp + 20);
                adaptador.append(String.format("%s: %s", nomeAdaptador, ip));
            }
        }
        return adaptador.toString();
    }

}
