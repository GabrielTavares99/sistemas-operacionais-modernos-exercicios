package semaforo.corridaPessoas;

import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        for (int i = 1; i <= 4; i++) {
            new Pessoa(i, semaphore).start();
        }

    }
}
