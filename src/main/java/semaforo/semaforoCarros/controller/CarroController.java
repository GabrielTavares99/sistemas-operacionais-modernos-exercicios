package semaforo.semaforoCarros.controller;

import semaforo.semaforoCarros.model.Cor;
import semaforo.semaforoCarros.model.Direcao;
import semaforo.semaforoCarros.view.Carro;

import java.util.concurrent.Semaphore;

public class CarroController extends Thread {

    private Semaphore semaforo;
    private Cor cor;
    private Direcao direcao;
    private Carro carro;
    private int distanciaPercorrer = 250;

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
        int distInit = carro.getX();
        int pInit = 0;
        int pEnd = 0;
        boolean direcaoPositiva = direcao.equals(Direcao.LESTE) || direcao.equals(Direcao.SUL);

        boolean mexeEixoY = direcao.equals(Direcao.NORTE) || direcao.equals(Direcao.SUL);

        int step = 0;
        if (direcaoPositiva)
            step += 10;
        else
            step -= 10;

        if (mexeEixoY && step > 0) {
            pInit = carro.getY();
            pEnd = carro.getY() + distanciaPercorrer;
        } else if (mexeEixoY && step < 0) {
            pInit = carro.getY();
            pEnd = carro.getY() - distanciaPercorrer;
        }

        if (!mexeEixoY && step > 0) {
            pInit = carro.getX();
            pEnd = carro.getX() + distanciaPercorrer;
        } else if (!mexeEixoY && step < 0) {
            pInit = carro.getX();
            pEnd = carro.getX() - distanciaPercorrer;
        }


        if (step > 0) {
            while (pInit < pEnd) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mexeEixoY)
                    carro.setLocation(carro.getX(), pInit += step);
                else
                    carro.setLocation(pInit += step, carro.getY());
            }
        } else {
            while (pInit > pEnd) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (mexeEixoY)
                    carro.setLocation(carro.getX(), pInit += step);
                else
                    carro.setLocation(pInit += step, carro.getY());
            }
        }

        System.out.println(String.format("Carro %s terminou de cruzar", cor.toString()));
    }

    public void mexeEixo(int pInit, int pEnd, boolean eixoX, int step) {

    }


}
