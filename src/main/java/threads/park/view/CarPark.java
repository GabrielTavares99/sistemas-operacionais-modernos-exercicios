package threads.park.view;

import threads.park.controller.ThreadCar;

import java.util.concurrent.Semaphore;

public class CarPark {
    public static void main(String[] args) {

        int permissoes = 3;
        Semaphore semaforo = new Semaphore(permissoes);
        for (int idCar = 1; idCar <= 10; idCar++) {
            new ThreadCar(idCar, semaforo).start();
        }

    }
}
