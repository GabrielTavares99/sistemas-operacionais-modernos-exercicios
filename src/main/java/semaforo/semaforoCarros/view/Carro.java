package semaforo.semaforoCarros.view;

import semaforo.semaforoCarros.model.Cor;
import semaforo.semaforoCarros.model.Direcao;

import javax.swing.*;
import java.awt.*;

public class Carro extends JLabel {

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    private Cor cor;

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    private Direcao direcao;

    public Carro(Cor cor, Direcao direcao, int x, int y, int width, int heigth) {
        this.cor = cor;
        this.direcao = direcao;

        switch (cor) {
            case AZUL:
                setBackground(Color.BLUE);
                break;
            case AMARELO:
                setBackground(Color.YELLOW);
                break;
            case VERMELHO:
                setBackground(Color.RED);
                break;
            case VERDE:
                setBackground(Color.GREEN);
        }

        setBounds(x, y, width, heigth);
        setOpaque(true);

    }

}
