package threads.exemploAula.view;

import threads.exemploAula.controller.ThreadCalc;

public class Principal {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
//        int op =1;
        for (int op = 0; op <= 3; op++) {
            ThreadCalc threadCalc = new ThreadCalc(a, b, op);
            threadCalc.start();
        }
    }
}
