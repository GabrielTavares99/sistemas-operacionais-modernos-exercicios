package processos.view;

import processos.controller.ProcController;

public class Principal {
    public static void main(String[] args) {

        ProcController procController = new ProcController();

        System.out.println(procController.os());

        procController.propriedades();

    }
}
