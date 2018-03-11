package processos.interfaceRede.view;

import processos.interfaceRede.controller.RedesController;

import java.util.Scanner;
import java.util.StringJoiner;

public class MainRedesController {
    public static void main(String[] args) {

        RedesController redesController = new RedesController();

        String osName = System.getProperty("os.name");

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 99) {
            StringJoiner menu = new StringJoiner("\n");
            menu.add("Bem Vindo à Central de Redes:");
            menu.add("1 - Ver adaptadores de rede");
            menu.add("2 - Ver ping da rede");
            menu.add("99 - Sair");
            System.out.println(menu.toString());
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Adaptadores de rede:");
                    System.out.println(redesController.ip(osName));
                    break;
                case 2:
                    System.out.println("Ping médio: ");
                    System.out.println(redesController.ping(osName));
                    break;
                case 99:
                    System.out.println("Bye o/");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Opção inválida");
                    break;
            }

            System.out.println();
        }


    }
}
