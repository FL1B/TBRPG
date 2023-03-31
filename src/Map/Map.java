package Map;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.io.*;
import java.util.Scanner;
import javax.swing.ImageIcon;


public class Map extends JComponent {

    private Image playerImage;
    private Image wall;
    private Image grass;
    private Image tree;
    private int xc = PlayerPos.getX();
    private int yc = PlayerPos.getY();
    private int tileSize = 50;
    private int scale = 1000;
    private int mapSize = 7700;
    public int[][] mapArray;
    private JFrame window;

    public Map(JFrame window) {
        this.window = window;
        try {
            wall = new ImageIcon("src/images/textures/wall 16x16.png").getImage();
            grass = new ImageIcon("src/images/textures/grass_16x16.png").getImage();
            tree = new ImageIcon("src/images/textures/tree_16x16.png").getImage();
            loadMapArray("src/Map/noe.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setPlayerImg(String value) {
        playerImage = new ImageIcon(value).getImage();
    }

    // Laster inn mapArray.txt og putter det inn i mapArray.
    private void loadMapArray(String filename) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        int numRows = 100;
        int numCols = 100;
        mapArray = new int[numRows][numCols];

        String line;
        int row = 0;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split(",");
            if (tokens.length != numCols) {
                reader.close();
                throw new IllegalArgumentException("Line contains too few numbers");
            }

            for (int col = 0; col < numCols; col++) {
                mapArray[row][col] = Integer.parseInt(tokens[col]);
            }
            row++;
        }
        reader.close();
        if (row < numRows) {
            throw new IllegalArgumentException("File contains too few lines");
        }
    }


    // Lagrer PlayerPos slik at det synes i printMapArray
    public void setPlayerPos() {
        removePreviousPlayerPos();

        int row = PlayerPos.getY();
        int col = PlayerPos.getX();
        mapArray[row][col] = 8;

        xc = col;
        yc = row;
    }

    // Fjerner forrige posisjon på player dette ved å kjøre denne før man kjører savePlayerPos()
    public void removePreviousPlayerPos() {
        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[row].length; col++) {
                if (mapArray[row][col] == 8) {
                    mapArray[row][col] = 0;
                }
            }
        }
    }

    //# oppdaterer posisjon på kart.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offsetX = (window.getWidth() / 2) - (xc * tileSize);
        int offsetY = (window.getHeight() / 2) - (yc * tileSize);
        setPlayerPos();

        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[row].length; col++) {

                if (mapArray[row][col] == 1) {
                    g.drawImage(wall, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArray[row][col] == 0) {
                    g.drawImage(grass, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArray[row][col] == 2) {
                    g.drawImage(tree, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArray[row][col] == 8) {
                    g.drawImage(grass, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                    g.drawImage(playerImage, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }
            }
        }
    }
}