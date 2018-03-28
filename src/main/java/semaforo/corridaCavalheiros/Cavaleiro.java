package semaforo.corridaCavalheiros;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cavaleiro extends Thread {

    static boolean TOCHA = true;

    private Semaphore semaforo;
    private int id_num;
    int bonus = 0;
    private int posicao = 0;
    Random random = new Random();

    public Cavaleiro(Semaphore semaforo, int id_num) {
        this.semaforo = semaforo;
        this.id_num = id_num;
    }

    @Override
    public void run() {
        System.out.println(String.format("Cavaleiro #%d iniciando corrida...", id_num));
        while (posicao < 2000) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int deslocamento = (random.nextInt(2) + 2)+bonus;
            posicao += deslocamento;
            System.out.println(String.format("Cavaleiro #%d, andou %d,  está na posição %d", id_num, deslocamento, posicao));
            if (posicao >= 500 && TOCHA) {
                System.out.println(String.format("Cavaleiro #%d, pegou a tocha!!!", id_num));
                TOCHA = false;
                bonus+=2;
            }
        }

    }
}
