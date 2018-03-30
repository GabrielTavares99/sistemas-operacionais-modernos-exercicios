package semaforo.semaforoCarros.view;

import semaforo.semaforoCarros.controller.CarroController;
import semaforo.semaforoCarros.model.Cor;
import semaforo.semaforoCarros.model.Direcao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class TelaSemaforo extends JFrame {

    Carro lblVerde, lblVermelho, lblAzul, lblAmarelo;

    public TelaSemaforo() {
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(600, 600);
        setTitle("Semáforo de carros");

        lblVerde = new Carro(Cor.VERDE, Direcao.LESTE, 50, 275, 50, 50);
        lblAzul = new Carro(Cor.AZUL, Direcao.OESTE, this.getWidth()-100, 325, 50, 50);

        lblVermelho = new Carro(Cor.VERMELHO, Direcao.SUL, (this.getWidth()/2)-70, 50, 50, 50);
        lblAmarelo = new Carro(Cor.AMARELO, Direcao.NORTE, (this.getWidth()/2), 500, 50, 50);

        add(lblVerde);
        add(lblAzul);
        add(lblVermelho);
        add(lblAmarelo);

        Semaphore semaforo = new Semaphore(1);
//
        List<CarroController> carros = new ArrayList<>();
//
        carros.add(new CarroController(semaforo, lblVerde));
        carros.add(new CarroController(semaforo, lblAzul));
        carros.add(new CarroController(semaforo, lblVermelho));
        carros.add(new CarroController(semaforo, lblAmarelo));

        for (CarroController carro : carros) {
            carro.start();
        }

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
