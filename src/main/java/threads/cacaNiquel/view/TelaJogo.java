package threads.cacaNiquel.view;

import threads.cacaNiquel.controller.NumeroThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaJogo extends JFrame {

    public static boolean FIM_JOGO = false;

    public TelaJogo() {

        JFrame tela = this;
        tela.setLayout(null);
        tela.setLocationRelativeTo(null);
        tela.setSize(500, 500);
        tela.setTitle("Caça Níquel");

        JLabel lblTitulo = new JLabel("Jogo de Sorte Gabriel");
        lblTitulo.setFont(new Font("Capture it", Font.BOLD, 30));
        lblTitulo.setBounds(50, 100, 450, 50);
        this.add(lblTitulo);

        Numero numero1 = new Numero(50, (500 / 2) - 60);
        Numero numero2 = new Numero(170, (500 / 2) - 60);
        Numero numero3 = new Numero(290, (500 / 2) - 60);
        this.add(numero1);
        this.add(numero2);
        this.add(numero3);

        JButton jButton = new JButton("Jogar");
        jButton.setBounds(50, 350, 400, 30);
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jButton.setVisible(false);
                new NumeroThread(numero1, jButton).start();
                new NumeroThread(numero2, jButton).start();
                new NumeroThread(numero3, jButton).start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(jButton);

        tela.setVisible(true);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
