package semaforo.docs.semaforoCarros;

import semaforo.docs.semaforoCarros.controller.CarroController;
import semaforo.docs.semaforoCarros.model.Cor;
import semaforo.docs.semaforoCarros.model.Direcao;
import semaforo.docs.semaforoCarros.view.TelaSemaforo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Principal {
    public static void main(String[] args) {

//        Semaphore semaforo = new Semaphore(1);
//
//        List<CarroController> carros = new ArrayList<>();
//
//        carros.add(new CarroController(semaforo, Cor.VERDE, Direcao.LESTE));
//        carros.add(new CarroController(semaforo, Cor.VERMELHO, Direcao.SUL));
//        carros.add(new CarroController(semaforo, Cor.AMARELO, Direcao.NORTE));
//        carros.add(new CarroController(semaforo, Cor.AZUL, Direcao.OESTE));
//
//        for (CarroController carro: carros){
//            carro.start();
//        }
        new TelaSemaforo();


    }
}
