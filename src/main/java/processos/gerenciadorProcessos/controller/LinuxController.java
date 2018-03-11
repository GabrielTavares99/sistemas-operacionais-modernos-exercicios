package processos.gerenciadorProcessos.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LinuxController implements IComandosSo {

    @Override
    public String identificaSO() {
        return null;
    }

    @Override
    public boolean mataProcessoByPID(int pid) {
        try {
            Runtime.getRuntime().exec(String.format("kill %d", pid));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean mataProcessoByNomeProcesso(String nomeProcesso) {
        try {
            Runtime.getRuntime().exec(String.format("pkill %s", nomeProcesso));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void listaProcessos() {
        try {
            Process processo = Runtime.getRuntime().exec("ps -A");
            InputStream inputStream = processo.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader buffer = new BufferedReader(reader);
            String linha = buffer.readLine();
            while (linha != null) {
                System.out.println(linha);
                linha = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
