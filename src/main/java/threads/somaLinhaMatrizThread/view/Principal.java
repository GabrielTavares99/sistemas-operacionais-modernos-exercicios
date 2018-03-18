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

        System.out.println("Thread 1\n");
        ThreadCalculo threadCalculo = new ThreadCalculo(matriz);
        threadCalculo.run();
        System.out.println("Thread 2\n");
        ThreadCalculo threadCalculo1 = new ThreadCalculo(matriz);
        threadCalculo.run();
        System.out.println("Thread 3\n");
        ThreadCalculo threadCalculo2 = new ThreadCalculo(matriz);
        threadCalculo.run();

        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
