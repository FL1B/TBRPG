package Map;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.io.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import Main.Main;


public class Map extends JComponent {

    private Image playerImage;
    private Image wall;
    private Image grass;
    private Image grass2;
    private Image tree;
    private int xc = PlayerPos.getX();
    private int yc = PlayerPos.getY();
    private int tileSize = Main.zoom;
    private int scale = 1000;
    private int mapSize = Main.mapSize;
    public int[][] mapArrayOriginal;
    public int[][] mapArrayClone;
    public int playerBackgroundValue;
    public Image playerBackground;
    private JFrame window;

    public Map(JFrame window) {
        this.window = window;
        try {
            wall = new ImageIcon("src/images/textures/wall 16x16.png").getImage();
            grass = new ImageIcon("src/images/textures/grass_16x16.png").getImage();
            grass2 = new ImageIcon("src/images/textures/grass2_16x16.png").getImage();
            tree = new ImageIcon("src/images/textures/tree_16x16.png").getImage();
            loadMapArray("src/Map/map.txt", "src/Map/map_copy.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setPlayerImg(String value) {
        playerImage = new ImageIcon(value).getImage();
    }

    // Laster inn mapArrayOriginal.txt og putter det inn i mapArrayOriginal.
    private void loadMapArray(String fileNameOriginal, String fileNameClone) throws FileNotFoundException, IOException {
        BufferedReader readerOriginal = new BufferedReader(new FileReader(fileNameOriginal));
        BufferedReader readerClone = new BufferedReader(new FileReader(fileNameClone));
        int numRows = mapSize;
        int numCols = mapSize;
        mapArrayOriginal = new int[numRows][numCols];
        mapArrayClone = new int[numRows][numCols];

        String line;
        int row = 0;
        while ((line = readerOriginal.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] tokens = line.split(",");
            if (tokens.length != numCols) {
                readerOriginal.close();
                throw new IllegalArgumentException("Line contains too few numbers");
            }

            for (int col = 0; col < numCols; col++) {
                mapArrayOriginal[row][col] = Integer.parseInt(tokens[col]);
                mapArrayClone[row][col] = Integer.parseInt(tokens[col]);
            }
            row++;
        }
        readerOriginal.close();
        readerClone.close();
        if (row < numRows) {
            throw new IllegalArgumentException("File contains too few lines");
        }
    }


    // Lagrer PlayerPos slik at det synes i printMapArray
    public void setPlayerPos() {
        removePreviousPlayerPos();

        int row = PlayerPos.getY();
        int col = PlayerPos.getX();
        mapArrayOriginal[row][col] = 8;

        xc = col;
        yc = row;
    }

    // Fjerner forrige posisjon på player dette ved å kjøre denne før man kjører savePlayerPos()
    public void removePreviousPlayerPos() {
        for (int row = 0; row < mapArrayOriginal.length; row++) {
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                if (mapArrayOriginal[row][col] == 8) {
                    mapArrayOriginal[row][col] = 0;
                }
            }
        }
    }


    public void setPlayerBackground(int value) {
        if (value == 0) {
            playerBackground = new ImageIcon("src/images/textures/grass_16x16.png").getImage();
        } else if (value == 2) {
            playerBackground = new ImageIcon("src/images/textures/tree_16x16.png").getImage();
        } else {
            playerBackground = new ImageIcon("src/images/textures/tree_16x16.png").getImage();
        }
    }

    //# oppdaterer posisjon på kart.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offsetX = (window.getWidth() / 2) - (xc * tileSize);
        int offsetY = (window.getHeight() / 2) - (yc * tileSize);
        setPlayerPos();
        setPlayerBackground(999);////kuk kan sikkert fjernes etterhvert

        Random rand = new Random();

        for (int row = 0; row < mapArrayOriginal.length; row++) {
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                int randomNum = rand.nextInt(2);
                if (mapArrayOriginal[row][col] == 1) {
                    g.drawImage(wall, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayOriginal[row][col] == 8) {
                    if (mapArrayClone[row][col] == 0) {
                        g.drawImage(grass, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                        g.drawImage(playerImage, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                    } else if (mapArrayClone[row][col] == 3) {
                        g.drawImage(grass2, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                        g.drawImage(playerImage, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                    }
                } else if (mapArrayClone[row][col] == 0) {
                    g.drawImage(grass, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArrayClone[row][col] == 3) {
                    g.drawImage(grass2, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArrayOriginal[row][col] == 2) {
                    g.drawImage(tree, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }
            }
        }
    }
}