package threads.threadExibeSeuNumero.controller;

public class ThreadNumerica extends Thread{

    private int valor;
    public ThreadNumerica(int  valor){
        this.valor = valor;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(valor);
    }
}
