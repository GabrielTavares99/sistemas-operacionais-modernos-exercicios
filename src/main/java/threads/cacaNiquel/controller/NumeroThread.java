package threads.cacaNiquel.controller;

import javax.swing.*;
import java.util.Random;

public class NumeroThread extends Thread{

    Random random = new Random();
    JLabel lblNumero;
    JButton btnJogar;

    public NumeroThread(JLabel lblNumero, JButton btnJogar){

        this.lblNumero = lblNumero;
        this.btnJogar = btnJogar;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 150; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int num = random.nextInt(7);
            lblNumero.setText(String.valueOf(num+1));
        }
        btnJogar.setVisible(true);
    }
}
