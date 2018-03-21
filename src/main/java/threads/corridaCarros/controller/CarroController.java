package threads.corridaCarros.controller;

import threads.corridaCarros.model.ModeloCarro;

import javax.swing.*;
import java.util.Random;

import static threads.corridaCarros.view.TelaJogo.DISTANCIA_MAXIMA;
import static threads.corridaCarros.view.TelaJogo.VELOCIDADE_MAXIMA;


public class CarroController extends Thread {

    private final JLabel carro;
    private final ModeloCarro modeloCarro;
    private final JTextField txtVencedor;
    private final JTextField txtPerdedor;
    private JButton btnCorrer;

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int posicao;
    public Thread thread;
    int posicaoInicial;

    public CarroController(JLabel carro, int x, int y, ModeloCarro modeloCarro, JTextField txtVencedor, JTextField txtPerdedor, JButton btnCorrer) {
        this.carro = carro;
        this.modeloCarro = modeloCarro;
        this.txtVencedor = txtVencedor;
        this.txtPerdedor = txtPerdedor;
        posicaoInicial = x;
        this.btnCorrer = btnCorrer;
        carro.setBounds(x, y, 65, 30);
        carro.setOpaque(true);
        if (ModeloCarro.VERDE.equals(modeloCarro)) {
            ImageIcon image = new ImageIcon(System.getProperty("user.dir") + "/src/main/java/threads/corridaCarros/images/carro-verde.png");
            image.setImage(image.getImage().getScaledInstance(carro.getWidth(), carro.getHeight(), 100));
            carro.setIcon(image);
        } else {
            ImageIcon image = new ImageIcon(System.getProperty("user.dir") + "/src/main/java/threads/corridaCarros/images/carro-vermelho.png");
            image.setImage(image.getImage().getScaledInstance(carro.getWidth(), carro.getHeight(), 100));
            carro.setIcon(image);
        }
        thread = new Thread(this);
    }

    Random random = new Random();

    @Override
    public void run() {
        while (carro.getX() < DISTANCIA_MAXIMA) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int posicao = (random.nextInt(VELOCIDADE_MAXIMA)) / 30;
            System.out.println(posicao);
            carro.setBounds(carro.getX() + posicao, carro.getY(), carro.getWidth(), carro.getHeight());
        }
        System.out.println("CarroController" + modeloCarro.toString());
        if (txtVencedor.getText().isEmpty()) {
            txtVencedor.setText(modeloCarro.toString());
        } else {
            txtPerdedor.setText(modeloCarro.toString());
        }
        btnCorrer.setVisible(true);
        carro.setBounds(posicaoInicial, carro.getY(), carro.getWidth(), carro.getHeight());
    }

}
