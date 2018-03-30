package semaforo.corridaCavalheiros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Principal {

    static List<Boolean> PORTAS_DISPONIVEIS = new ArrayList<>();

    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        Random random = new Random();

        Boolean[] portas = new Boolean[]{false, false, false, false};
        portas[random.nextInt(portas.length)] = true;
        PORTAS_DISPONIVEIS.addAll(Arrays.asList(portas));

        for (int i = 1; i <= 4; i++) {
            new Cavaleiro(semaforo, i).start();
        }

    }
}
