package threads.threadExibeSeuNumero.view;

import threads.threadExibeSeuNumero.controller.ThreadNumerica;

public class Principal {
    public static void main(String[] args) {

        ThreadNumerica threadNumerica1 = new ThreadNumerica(1);
        ThreadNumerica threadNumerica2 = new ThreadNumerica(2);
        ThreadNumerica threadNumerica3 = new ThreadNumerica(3);
        ThreadNumerica threadNumerica4 = new ThreadNumerica(4);
        ThreadNumerica threadNumerica5 = new ThreadNumerica(5);

        threadNumerica1.run();
        threadNumerica2.run();
        threadNumerica3.run();
        threadNumerica4.run();
        threadNumerica5.run();
    }
}
