package Map;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;


public class Map extends JComponent {

    private Image img;
    private Image map1;
    private int xc = PlayerPos.getX();
    private int yc = PlayerPos.getY();
    private int tileSize = 100;
    private int scale = 1000;
    private int mapSize = 7700;
    public int[][] mapArray;
    private JFrame window;

    public Map(JFrame window) {
        this.window = window;
        try {
            img = new ImageIcon("src/Map/warrior_resting.png").getImage();
            map1 = new ImageIcon("src/Map/map1.png").getImage();
            loadMapArray("src/Map/mapArray.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadMapArray(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        int numRows = 7;
        int numCols = 7;
        mapArray = new int[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            if (!scanner.hasNextLine()) {
                throw new IllegalArgumentException("File contains too few lines");
            }

            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);

            for (int col = 0; col < numCols; col++) {
                if (!lineScanner.hasNextInt()) {
                    throw new IllegalArgumentException("Line contains too few numbers");
                }
                mapArray[row][col] = lineScanner.nextInt();
            }
            lineScanner.close();
        }
        scanner.close();
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
            g.drawImage(map1, +PlayerPos.getX()-mapSize/2,+PlayerPos.getY()-mapSize/2, mapSize, mapSize, null);
            g.drawImage(img, -offsetX-60, -offsetY-40, playerWidth, playerHeight, null);
        } else {
            System.out.println("Error: Player img not loading");
        }

        for (int i = 0; i < 7; i++) {
            for (int y = 0; y < 7; y++) {
                g.drawRect(i * scale + PlayerPos.getX()-mapSize/2, y * scale + PlayerPos.getY()-mapSize/2, tileSize * 10, tileSize * 10);
            }
        }
    }
}

