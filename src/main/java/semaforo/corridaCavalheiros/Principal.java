package semaforo.corridaCavalheiros;

import java.util.concurrent.Semaphore;

public class Principal {


    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        for (int i = 1; i <= 4 ; i++) {
            new Cavaleiro(semaforo, i).start();
        }

    }
}
