package threads.park.controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread {

    private int idCar;
    private static int posChegada;
    private static int posSaida;
    private Semaphore semaforo;

    public ThreadCar(int idCar, Semaphore semaforo) {
        this.idCar = idCar;
        this.semaforo = semaforo;
    }

    public void carroAndando() {
        int distFinal = (int) ((Math.random() / 2001) + 1000);
        int distPercorrida = 0;
        int deslocamento = (int) ((Math.random() * 6) + 10);
        int tempo = 30;
        while (distPercorrida < distFinal) {
            distPercorrida += deslocamento;
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("Carro #%d andou %d metros", idCar, distPercorrida));
        }
        posChegada++;
        System.out.println(String.format("Carro #%d foi o %d carro a chegar", idCar, posChegada));
    }

    private void carroParado() {
        System.out.println(String.format("Carro #%d estacionou", idCar));
        int tempoParado = (int) ((Math.random() * 2051) + 500);
        try {
            Thread.sleep(tempoParado);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void carroSaindo() {
        posSaida++;
        System.out.println(String.format("Carro #%d foi o %d a sair", idCar, posSaida));
    }

    @Override
    public void run() {
        carroAndando();
        try {
            semaforo.acquire();
            carroParado();
            carroSaindo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
