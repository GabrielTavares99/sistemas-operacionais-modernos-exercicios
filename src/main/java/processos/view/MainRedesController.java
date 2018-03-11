package processos.view;

import processos.controller.RedesController;

public class MainRedesController {
    public static void main(String[] args) {

        RedesController redesController = new RedesController();

        System.out.print("Adaptadores de rede:");
        System.out.println(redesController.ip(System.getProperty("os.name")));
    }
}
