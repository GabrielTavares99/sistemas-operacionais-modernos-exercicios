package processos.view;

import processos.controller.RedesController;

public class MainRedesController {
    public static void main(String[] args) {

        RedesController redesController = new RedesController();

        String osName = System.getProperty("os.name");

        System.out.print("Adaptadores de rede:");
        System.out.println(redesController.ip(osName));

        System.out.println();

        System.out.println("Ping médio: ");
        System.out.println(redesController.ping(osName));


    }
}
