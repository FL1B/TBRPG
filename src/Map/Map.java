package Map;

import javax.swing.*;
import java.awt.*;

public class Map extends JComponent {

    int xc = PlayerPos.getX();
    int yc = PlayerPos.getY();
    public void paint(Graphics g) {

        g.drawRect(345,345,10,10);
        g.fillRect(345,345,10,10);

        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 7; y++) {
                g.drawRect(i*100,y*100,10*10,10*10);
            }
        }
    }
    public static void main(String[] a) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(345, 345, 1000, 1000);
        window.setTitle("TRPG");
        window.getContentPane().add(new Map());
        window.setVisible(true);
    }

}
