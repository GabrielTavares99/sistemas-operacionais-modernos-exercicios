package semaforo.corridaCavalheiros;

import java.util.Random;
import java.util.concurrent.Semaphore;

import static semaforo.corridaCavalheiros.Principal.PORTAS_DISPONIVEIS;

public class Cavaleiro extends Thread {

    static boolean TOCHA = true;
    static boolean PEDRA_BRILHANTE = true;

    private Semaphore semaforo;
    private int id_num;
    int bonus = 0;
    private int posicao = 0;
    Random random = new Random();

    String encontrouSaida = "encontrou a saída";
    String foiDevorado = "foi devorado pelo monstro";

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
            int deslocamento = (random.nextInt(2) + 2) + bonus;
            posicao += deslocamento;
            System.out.println(String.format("Cavaleiro #%d, andou %d,  está na posição %d", id_num, deslocamento, posicao));

            try {
                semaforo.acquire();
                if (posicao >= 500 && TOCHA) {
                    System.out.println(String.format("Cavaleiro #%d, pegou a tocha!!!", id_num));
                    TOCHA = false;
                    bonus += 2;
                }
                semaforo.release();
                semaforo.acquire();
                if (posicao >= 1500 && PEDRA_BRILHANTE) {
                    System.out.println(String.format("Cavaleiro #%d, pegou a pedra brilhante!!!", id_num));
                    PEDRA_BRILHANTE = false;
                    bonus += 2;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaforo.release();
            }
        }
        System.out.println(String.format("Cavaleiro #%d está na escolha da porta!", id_num));
        try {
            semaforo.acquire();
            int escolhaPorta = random.nextInt(PORTAS_DISPONIVEIS.size());
            String mensagemDestino = PORTAS_DISPONIVEIS.get(escolhaPorta) ? encontrouSaida : foiDevorado;
            System.out.println(String.format("Cavaleiro #%d ", id_num).concat(mensagemDestino));
            PORTAS_DISPONIVEIS.remove(escolhaPorta);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }


    }
}
