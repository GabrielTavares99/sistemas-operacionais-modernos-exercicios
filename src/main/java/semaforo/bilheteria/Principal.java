package semaforo.bilheteria;

import java.util.concurrent.Semaphore;

public class Principal {

    static int QTD_INGRESSOS_DISPONIVEIS = 100;

    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        for (int i = 1; i <= 300; i++) {
            new Cliente(i, semaforo).start();
        }

    }
}
