package threads.somaLinhaMatrizThread.view;

import threads.somaLinhaMatrizThread.controller.ThreadCalculo;

import java.util.Random;

public class Principal {
    public static void main(String[] args) {

        Random random = new Random();
        double[][] matriz = new double[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = random.nextInt(10);
            }
        }

        new ThreadCalculo(matriz,1).run();
        new ThreadCalculo(matriz, 2).run();
        new ThreadCalculo(matriz,3 ).run();

        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
