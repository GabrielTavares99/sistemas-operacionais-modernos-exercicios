package threads.corridaSapoConsole.controller;

import java.util.Random;

import static threads.corridaSapoConsole.view.Principal.DISTANCIA_MAXIMA;
import static threads.corridaSapoConsole.view.Principal.POSICAO;

public class Sapo extends Thread {

    private Random random = new Random();

    private int posicao = 0;

    private int id;

    public Sapo(int id){

        this.id = id;
    }
    @Override
    public void run() {
        while (posicao < DISTANCIA_MAXIMA) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int salto = random.nextInt(5);
            posicao += salto;
            System.out.println(String.format("Sapo %d (Salto %d - Posição %d) ", id, salto, posicao));
        }
        System.out.println(String.format("-------- Sapo %d Colocação %d --------", id, POSICAO));

        POSICAO++;
//        System.out.println(System.currentTimeMillis());
    }
}
