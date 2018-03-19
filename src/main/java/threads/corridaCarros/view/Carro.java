package threads.corridaCarros.view;

import threads.corridaCarros.model.ModeloCarro;

import javax.swing.*;
import java.util.Random;

import static threads.corridaCarros.view.TelaJogo.DISTANCIA_MAXIMA;
import static threads.corridaCarros.view.TelaJogo.VELOCIDADE_MAXIMA;

public class Carro extends JLabel implements Runnable {

    private final ModeloCarro modeloCarro;
    private final JTextField txtVencedor;
    private final JTextField txtPerdedor;

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int posicao;
    Thread thread;

    public Carro(int x, int y, ModeloCarro modeloCarro, JTextField txtVencedor, JTextField txtPerdedor) {
        this.modeloCarro = modeloCarro;
        this.txtVencedor = txtVencedor;
        this.txtPerdedor = txtPerdedor;
        this.setBounds(x, y, 65, 30);
        this.setOpaque(true);
        if (ModeloCarro.VERDE.equals(modeloCarro)) {
            ImageIcon image = new ImageIcon(System.getProperty("user.dir") + "/src/main/java/threads/corridaCarros/images/carro-verde.png");
            image.setImage(image.getImage().getScaledInstance(getWidth(), getHeight(), 100));
            this.setIcon(image);
        } else {
            ImageIcon image = new ImageIcon(System.getProperty("user.dir") + "/src/main/java/threads/corridaCarros/images/carro-vermelho.png");
            image.setImage(image.getImage().getScaledInstance(getWidth(), getHeight(), 100));
            this.setIcon(image);
        }
        thread = new Thread(this);
    }

    Random random = new Random();

    @Override
    public void run() {
        while (getX() < DISTANCIA_MAXIMA) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int posicao = random.nextInt(VELOCIDADE_MAXIMA);
            this.setBounds(getX() + posicao, getY(), getWidth(), getHeight());
        }
        System.out.println("Carro" + modeloCarro.toString());
        if (txtVencedor.getText().isEmpty()){
            txtVencedor.setText(modeloCarro.toString());
        }else {
            txtPerdedor.setText(modeloCarro.toString());
        }
    }

    public int getId() {
        return id;
    }
}
