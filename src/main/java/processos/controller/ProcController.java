package processos.controller;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

public class ProcController {

    public ProcController() {
//        O super pega alguns métodos da classe object
        super();
    }

    public String os() {
        return System.getProperty("os.name");
    }

    public void propriedades() {
        Properties properties = System.getProperties();
        Set<Object> chaves = properties.keySet();
        for (Object key : chaves) {
            System.out.print(key);
            System.out.print("=");
            System.out.println(System.getProperty(key.toString()));
        }
    }

    public void chamaProcesso(String caminhoProcesso) {
        try {
            Runtime.getRuntime().exec(caminhoProcesso);
        } catch (IOException e) {
//            e.printStackTrace();
            String errMsg = e.getMessage();
//            System.out.println(errMsg);
            if (errMsg.contains("740") || errMsg.contains("2")) {
//                CHAMA CREDENCIAIS
                StringBuffer buffer = new StringBuffer();
//                buffer.append("cmd /c");///c abre as credenciais
                buffer.append("cmd /c");///c abre as credenciais
                buffer.append(" ");
                buffer.append(caminhoProcesso);
                try {
                    Runtime.getRuntime().exec(buffer.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, errMsg, "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void leProcesso(String comandoTaskList){
        Process process;
        try {
            process = Runtime.getRuntime().exec(comandoTaskList);
            InputStream fluxo = process.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            while (linha != null){
                System.out.println(linha);
                linha = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mataProcesso(String processo){
//            String cmdPid = "TASKKILL /PID ";
//            String cmdNome = "TASKKILL /IM";
        String cmdPid = "top";
        String cmdNome = "top";
            int pid = 0;
            StringBuffer buffer = new StringBuffer();
            try {
                pid = Integer.parseInt(processo);
                buffer.append(cmdPid);
                buffer.append(pid);
            }catch (NumberFormatException e){
                buffer.append(cmdNome);
                buffer.append(processo);
            }
            chamaProcesso(buffer.toString());
    }

}
