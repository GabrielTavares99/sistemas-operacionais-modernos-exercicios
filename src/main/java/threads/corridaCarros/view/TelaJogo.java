package threads.corridaCarros.view;

import threads.corridaCarros.controller.CarroController;
import threads.corridaCarros.model.ModeloCarro;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TelaJogo extends JFrame {

    public static int VELOCIDADE_MAXIMA = 60;
    public static int DISTANCIA_MAXIMA;
    public static int POSICAO = 1;

    public TelaJogo() {

        JFrame tela = this;
        tela.setTitle("Corrida de carros");
        tela.setSize(800, 600);
        tela.setLocationRelativeTo(null);
        tela.setLayout(null);

        JLabel lblVencedor = new JLabel("Vencedor");
        lblVencedor.setBounds(5, 100, 100, 40);
        this.add(lblVencedor);

        JTextField txtVencedor = new JTextField();
        txtVencedor.setBounds(80, 100, 100, 40);
        txtVencedor.setEditable(false);
        this.add(txtVencedor);

        JLabel lblPerdedor = new JLabel("Perdedor");
        lblPerdedor.setBounds(5, 150, 100, 40);
        this.add(lblPerdedor);

        JTextField txtPerdedor = new JTextField();
        txtPerdedor.setEditable(false);
        txtPerdedor.setBounds(80, 150, 100, 40);
        this.add(txtPerdedor);

        JButton btnComecar = new JButton("Correr");
        btnComecar.setBounds(50, 350, 100, 50);
        this.add(btnComecar);


        DISTANCIA_MAXIMA = tela.getWidth() - 100;
        JLabel lblCarro1 = new JLabel();
        new CarroController(lblCarro1, 50, 200, ModeloCarro.VERDE, txtVencedor, txtPerdedor, btnComecar);
        this.add(lblCarro1);

        JLabel lblCarro2 = new JLabel();
        new CarroController(lblCarro2, 50, 300, ModeloCarro.VERMELHO, txtVencedor, txtPerdedor, btnComecar);
        this.add(lblCarro2);

        btnComecar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnComecar.setVisible(false);
                txtVencedor.setText("");
                txtPerdedor.setText("");
                new CarroController(lblCarro1, 50, 200, ModeloCarro.VERDE, txtVencedor, txtPerdedor, btnComecar).start();
                new CarroController(lblCarro2, 50, 300, ModeloCarro.VERMELHO, txtVencedor, txtPerdedor, btnComecar).start();
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

        tela.setVisible(true);
        tela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
