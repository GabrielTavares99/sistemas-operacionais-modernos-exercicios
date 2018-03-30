package semaforo.semaforoCarros;

import semaforo.semaforoCarros.view.TelaSemaforo;

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
