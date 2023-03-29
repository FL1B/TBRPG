package Map;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Map extends JComponent {

    Image img;
    Image map1;
    int xc = PlayerPos.getX();
    int yc = PlayerPos.getY();
    int tileSize = 110;
    int scale = 1100;
    JFrame window;

    public Map(JFrame window) {
        this.window = window;
        try {
            img = new ImageIcon("src/Map/warrior_resting.png").getImage();
            map1 = new ImageIcon("src/Map/map1.png").getImage();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (img != null) {
            int playerWidth = 10 * 10;
            int playerHeight = 10 * 10;
            int halfWindowWidth = window.getWidth() / 2;
            int halfWindowHeight = window.getHeight() / 2;
            int offsetX = xc - halfWindowWidth;
            int offsetY = yc - halfWindowHeight;
            g.drawImage(map1, 0+PlayerPos.getX(),+PlayerPos.getY(), 7700, 7700, null);

            g.drawImage(img, -offsetX, -offsetY, playerWidth, playerHeight, null);
        } else {
            System.out.println("Error: Player img not loading");
        }

        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 7; y++) {
                g.drawRect(i * scale + PlayerPos.getX(), y * scale + PlayerPos.getY(), tileSize * 10, tileSize * 10);
            }
        }


    }
}
