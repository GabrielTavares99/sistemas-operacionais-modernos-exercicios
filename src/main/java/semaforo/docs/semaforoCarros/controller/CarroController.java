package semaforo.docs.semaforoCarros.controller;

import semaforo.docs.semaforoCarros.model.Cor;
import semaforo.docs.semaforoCarros.model.Direcao;

import java.util.concurrent.Semaphore;

public class CarroController extends Thread {

    private Semaphore semaforo;
    private Cor cor;
    private Direcao direcao;

    public CarroController(Semaphore semaforo, Cor cor, Direcao direcao) {
        this.semaforo = semaforo;
        this.cor = cor;
        this.direcao = direcao;
    }

    @Override
    public void run() {

        System.out.println(String.format("Carro %s esperando", cor.toString(), direcao.toString()));
        try {
            semaforo.acquire();
            atravessar();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }

    }

    public void atravessar() {
        System.out.println(String.format("Carro %s cruzando sentido %s", cor.toString(), direcao.toString()));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("Carro %s terminou de cruzar", cor.toString()));
    }

}
