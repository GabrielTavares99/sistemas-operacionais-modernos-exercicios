package semaforo.bilheteria;

import java.util.Random;
import java.util.concurrent.Semaphore;

import static semaforo.bilheteria.Principal.QTD_INGRESSOS_DISPONIVEIS;

public class Cliente extends Thread {

    private int id_num;
    private Semaphore semaforo;
    Random random = new Random();
    private int qtdIngressosCont = 0;

    public Cliente(int id_num, Semaphore semaforo) {
        this.id_num = id_num;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        if (!fazerLogin()) {
            System.out.println(String.format("Pessoa #%d TIMEOUT Login", id_num));
            return;
        }
        if (!comprarIngresso()) {
            System.out.println(String.format("Pessoa #%d NÃO CONSEGUE COMPRAR TIMEOUT", id_num));
            return;
        }
        validarCompra();
    }

    private void validarCompra() {

        try {
            semaforo.acquire();
            if (qtdIngressosCont <= QTD_INGRESSOS_DISPONIVEIS) {
                QTD_INGRESSOS_DISPONIVEIS -= qtdIngressosCont;
                System.out.println(String.format("Pessoa #%d comprou %d ingressos, restam %d disponíveis", id_num, qtdIngressosCont, QTD_INGRESSOS_DISPONIVEIS));
            } else {
                System.out.println(String.format("Pessoa #%d, não há ingressos disponíveis! %d atualmente", id_num, QTD_INGRESSOS_DISPONIVEIS));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }

    }

    private boolean comprarIngresso() {
        System.out.println(String.format("Pessoa #%d Iniciando compra ingresso...", id_num));
        int qtdIngressos = random.nextInt(4) + 1;
        System.out.println(String.format("Pessoa #%d quer %d ingressos", id_num, qtdIngressos));
        int tempoCompra = random.nextInt(2001) + 1000;

        try {
            Thread.sleep(tempoCompra);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        qtdIngressosCont = qtdIngressos;
        return !(tempoCompra > 2500);
    }

    private boolean fazerLogin() {
        System.out.println(String.format("Pessoa #%d Iniciando login...", id_num));
        int tempoLogin = 0;

        try {
            tempoLogin = random.nextInt(2001) + 50;// TODO: 27/03/18
            Thread.sleep(tempoLogin);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (tempoLogin >= 1000)
            return false;
        return true;
    }

    public int getId_num() {
        return id_num;
    }

    public void setId_num(int id_num) {
        this.id_num = id_num;
    }
}
