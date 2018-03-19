package threads.corridaCarros.controller;

import threads.corridaCarros.view.Carro;

import java.util.List;

public class CarrosController extends Thread {

    private List<Carro> carros;

    public CarrosController(List<Carro> carros) {

        this.carros = carros;
    }

    @Override
    public void run() {

        for (Carro carro : carros) {
            carro.start();
        }

    }
}
