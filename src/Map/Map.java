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
    private int tileSize = 100;
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
            loadMapArray("src/Map/mapArray.txt");
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
        int numRows = 10;
        int numCols = 10;
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


    //Printer mapArray i konsoll
    //public void printMapArray() {
        //for (int row = 0; row < mapArray.length; row++) {
            //for (int col = 0; col < mapArray[row].length; col++) {
                //System.out.print(mapArray[row][col] + " ");
            //}
            //System.out.println();
        //}
    //}

    // Lagrer PlayerPos slik at det synes i printMapArray
    public void setPlayerPos() {
        removePreviousPlayerPos();

        int row = PlayerPos.getY()-1;
        int col = PlayerPos.getX()-1;
        mapArray[row][col] = 8;

        System.out.println("row " + row + " col " + col);
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

        if (playerImage != null) {
            // Regner ut hvor karaktere skal være plassert i window.
            int playerWidth = 10 * 10;
            int playerHeight = 10 * 10;
            int halfWindowWidth = window.getWidth() / 2;
            int halfWindowHeight = window.getHeight() / 2;
            int offsetX = xc - halfWindowWidth;
            int offsetY = yc - halfWindowHeight;


            setPlayerPos();

        } else {
            System.out.println("Error: Player img not loading");
        }

        for (int row = 0; row < mapArray.length; row++) {
            for (int col = 0; col < mapArray[row].length; col++) {
                if (mapArray[row][col] == 1) {
                    g.drawImage(wall,col*tileSize+PlayerPos.getX() , row*tileSize+PlayerPos.getY(), tileSize, tileSize, null);
                } else if (mapArray[row][col] == 0) {
                    g.drawImage(grass,col*tileSize+PlayerPos.getX() , row*tileSize+PlayerPos.getY(), tileSize, tileSize, null);
                } else if (mapArray[row][col] == 2) {
                    g.drawImage(tree,col*tileSize+PlayerPos.getX() , row*tileSize+PlayerPos.getY(), tileSize, tileSize, null);
                } else if (mapArray[row][col] == 8) {
                    g.drawImage(grass,col*tileSize+PlayerPos.getX() , row*tileSize+PlayerPos.getY(), tileSize, tileSize, null);
                    g.drawImage(playerImage,col*tileSize+PlayerPos.getX() , row*tileSize+PlayerPos.getY(), tileSize, tileSize, null);
                }
            }
        }

        // Tegner alle bioms 7x7
        //for (int i = 0; i < 7; i++) {
            //for (int y = 0; y < 7; y++) {
                //g.drawRect(i * scale + PlayerPos.getX()-mapSize/2, y * scale + PlayerPos.getY()-mapSize/2, tileSize * 10, tileSize * 10);
            //}
        //}
    }
}