package Map;

import javax.swing.*;
import java.awt.*;

public class Map extends JComponent {

    int xc = PlayerPos.getX();
    int yc = PlayerPos.getY();
    int tileSize = 10;
    int scale = 100;
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(PlayerPos.getX(), PlayerPos.getY(), 10, 10);
        g.fillRect(PlayerPos.getX(), PlayerPos.getY(), 10, 10);


        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 7; y++) {
                g.drawRect(i*scale,y*scale,tileSize*10,tileSize*10);
            }
        }
    }
}
