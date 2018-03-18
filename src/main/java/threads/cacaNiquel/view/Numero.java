package threads.cacaNiquel.view;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Numero extends JLabel {

    public Numero(int x, int y) {
        setBounds(x, y, 100, 100);
        setOpaque(true);
        setBackground(Color.cyan);
        setText("0");
        setFont(new Font("Capture it", Font.BOLD, 80));
        setForeground(Color.black);
    }

}
