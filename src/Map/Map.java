package Map;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;

import Main.Main;


public class Map extends JComponent {

    Image img;
    int xc = PlayerPos.getX();
    int yc = PlayerPos.getY();
    int tileSize = 110;
    int scale = 1100;
    JFrame window;

    public Map(JFrame window) {
        this.window = window;
        try {
            img = new ImageIcon("src/Map/warrior_resting.png").getImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img != null) {
            g.drawImage(img, PlayerPos.getX() - window.getWidth() / 2, PlayerPos.getY() - window.getHeight() / 2, 10*10, 10*10, null);
            System.out.println("Player img loading");
        }else {
            System.out.println("Error: Player img not loading");
        }

        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 7; y++) {
                g.drawRect(i*scale, y*scale, tileSize*10, tileSize*10);
            }
        }
    }
}
