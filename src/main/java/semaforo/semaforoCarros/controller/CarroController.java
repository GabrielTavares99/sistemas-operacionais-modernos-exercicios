package semaforo.docs.semaforoCarros.controller;

import semaforo.docs.semaforoCarros.model.Cor;
import semaforo.docs.semaforoCarros.model.Direcao;
import semaforo.docs.semaforoCarros.view.Carro;

import java.util.concurrent.Semaphore;

public class CarroController extends Thread {

    private Semaphore semaforo;
    private Cor cor;
    private Direcao direcao;
    private Carro carro;
    private int distanciaPercorrer = 500;

    public CarroController(Semaphore semaforo, Carro carro) {
        this.semaforo = semaforo;
        this.cor = carro.getCor();
        this.carro = carro;
        this.direcao = carro.getDirecao();
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
        int distanciaPercorrida = carro.getX();
        int distanciaFinal = carro.getX() + 400;
        boolean comparacao = false;

        boolean direcaoPositiva = direcao.equals(Direcao.LESTE) || direcao.equals(Direcao.SUL);
        boolean mexeEixoX = direcao.equals(Direcao.LESTE) || direcao.equals(Direcao.OESTE);

        while (distanciaPercorrida < distanciaFinal) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (direcaoPositiva) {
                distanciaPercorrida += 10;
            } else {
                distanciaPercorrida -= 10;
            }

            if (mexeEixoX)
                carro.setLocation(distanciaPercorrida, carro.getY());
            else
                carro.setLocation(carro.getX(), distanciaFinal);
        }


        System.out.println(String.format("Carro %s terminou de cruzar", cor.toString()));
    }

}
