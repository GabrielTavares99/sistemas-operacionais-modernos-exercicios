package threads.somaLinhaMatrizThread.controller;

public class ThreadCalculo extends Thread {

    double[][] matriz;
    private int id;

    public ThreadCalculo(double[][] matriz, int id) {

        this.matriz = matriz;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(String.format("\nThread %d", id));
        for (int i = 0; i < 3; i++) {
            double cont = 0;
            for (int j = 0; j < 5; j++) {
                cont += matriz[i][j];
            }
            System.out.println(String.format("Linha %d: %.1f", i+1, cont));
        }
    }

}
