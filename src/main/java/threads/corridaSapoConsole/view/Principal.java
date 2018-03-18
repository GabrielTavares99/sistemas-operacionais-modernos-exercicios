package threads.corridaSapoConsole.view;

import threads.corridaSapoConsole.controller.Sapo;

public class Principal {
    public static final int DISTANCIA_MAXIMA = 100;
    public static int POSICAO = 1;
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Sapo(i+1).start();
            System.out.println();
        }

    }
}
