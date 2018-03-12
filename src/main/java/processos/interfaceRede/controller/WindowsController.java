package processos.interfaceRede.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class WindowsController implements ISoController {


    @Override
    public StringBuilder adaptadorRede(StringBuilder adaptador) {
        return null;
    }

    @Override
    public double ping() {

        String comandoPing = "ping -n 10 www.google.com";
        StringBuilder pingString = new StringBuilder();
        try {
            Process processo = Runtime.getRuntime().exec(comandoPing);
            InputStream stream = processo.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linha = bufferedReader.readLine();
            while (linha != null){
                System.out.println(linha);
                pingString.append(linha);
                bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int inicio = pingString.indexOf("Média");
        int fim = inicio+14;
        String sub = pingString.toString().substring(inicio, fim);
        System.out.println(sub);
        return 0;
    }
}
