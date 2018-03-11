package processos.gerenciadorProcessos.view;

import processos.gerenciadorProcessos.controller.ProcessosController;

import java.util.Scanner;
import java.util.StringJoiner;

public class Principal {
    public static void main(String[] args) {

        ProcessosController processosController = new ProcessosController();
        String nomeSo = processosController.identificaSO();

        StringJoiner menu = new StringJoiner("\n");
        menu.add("--------------------------------");
        menu.add("Controle de Processos");
        menu.add("1 - Listar processos");
        menu.add("2 - Matar processos por PID");
        menu.add("3 - Matar processos por nome");
        menu.add("99 - Sair");
        menu.add("--------------------------------");

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println(menu);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Listando processo ativos:");
                    processosController.listaProcessos(nomeSo);
                    break;
                case 2:
                    System.out.println("Digite o PID do processo: ");
                    int pid = scanner.nextInt();
                    processosController.mataProcessoByPID(nomeSo, pid);
                    break;
                case 3:
                    System.out.println("Digite o nome do processo: ");
                    String nomeProcesso = scanner.next();
                    processosController.mataProcessoByNomeProcesso(nomeSo, nomeProcesso);
                    break;
                case 99:
                    System.out.println("Bye o/");
                    System.exit(0);
                default:
                    System.err.println("Opção inválida!");
                    break;
            }
        } while (opcao != 99);
    }
}
