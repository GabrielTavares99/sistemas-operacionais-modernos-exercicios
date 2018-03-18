package threads.threadExibeSeuNumero.controller;

public class ThreadNumerica extends Thread{

    private int valor;
    public ThreadNumerica(int  valor){
        this.valor = valor;
    }

    @Override
    public void run() {
        System.out.println(valor);
    }
}
