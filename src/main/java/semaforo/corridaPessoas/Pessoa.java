package semaforo.corridaPessoas;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Pessoa extends Thread {

    private int id_pessoa;
    private Semaphore semaphore;
    private int distanciaAtual;
    Random random = new Random();

    public Pessoa(int id_pessoa, Semaphore semaphore) {
        this.id_pessoa = id_pessoa;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        System.out.println(String.format("Pessoa #%d iniciando corrida!", id_pessoa));
        while (distanciaAtual < 200) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int distancia = random.nextInt(4) + 2;
            distanciaAtual += distancia;
            System.out.println(String.format("Pessoa #%d andou %d, e está na posição %d", id_pessoa, distancia, distanciaAtual));
        }

        try {
            System.out.println(String.format("Pessoa #%d esperando pra tentar abir a porta", id_pessoa));
            semaphore.acquire();
            System.out.println(String.format("Pessoa #%d começou a abir a porta", id_pessoa));
            int tempoAbrirPorta = random.nextInt(1001) + 1000;
            Thread.sleep(tempoAbrirPorta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        System.out.println(String.format("Pessoa #%d atravessou a porta", id_pessoa));

    }
}
