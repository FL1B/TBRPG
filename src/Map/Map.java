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
    private Image roofTop;
    private Image roofMid;
    private Image roofFront;
    private Image roofTopLeft;
    private Image roofTopRight;
    private Image roofLeft;
    private Image roofRight;
    private Image roofFrontLeft;
    private Image roofFrontRight;
    private Image wallMid;
    private Image wallMidOn;
    private Image wallMidOff;
    private Image wallLeft;
    private Image wallRight;
    private Image door;
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
            roofTop = new ImageIcon("src/images/textures/building/roof_top.png").getImage();
            roofMid = new ImageIcon("src/images/textures/building/roof_mid.png").getImage();
            roofFront = new ImageIcon("src/images/textures/building/roof_front.png").getImage();
            roofLeft = new ImageIcon("src/images/textures/building/roof_left.png").getImage();
            roofRight = new ImageIcon("src/images/textures/building/roof_right.png").getImage();
            roofTopLeft = new ImageIcon("src/images/textures/building/roof_top_left.png").getImage();
            roofTopRight = new ImageIcon("src/images/textures/building/roof_top_right.png").getImage();
            roofFrontLeft = new ImageIcon("src/images/textures/building/roof_front_left.png").getImage();
            roofFrontRight= new ImageIcon("src/images/textures/building/roof_front_right.png").getImage();
            wallMid = new ImageIcon("src/images/textures/building/wall_mid.png").getImage();
            wallMidOn = new ImageIcon("src/images/textures/building/wall_mid_on.png").getImage();
            wallMidOff = new ImageIcon("src/images/textures/building/wall_mid_off.png").getImage();
            wallLeft = new ImageIcon("src/images/textures/building/wall_front_left.png").getImage();
            wallRight = new ImageIcon("src/images/textures/building/wall_front_right.png").getImage();
            door = new ImageIcon("src/images/textures/building/wall_door.png").getImage();
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
                } else if (mapArrayClone[row][col] == 10) {
                    g.drawImage(roofTop, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArrayClone[row][col] == 11) {
                    g.drawImage(roofMid, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArrayClone[row][col] == 12) {
                    g.drawImage(roofFront, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                } else if (mapArrayClone[row][col] == 13) {
                    g.drawImage(wallMid, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 14) {
                    g.drawImage(roofTopLeft, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);//######
                }else if (mapArrayClone[row][col] == 15) {
                    g.drawImage(roofLeft, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 16) {
                    g.drawImage(roofFrontLeft, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 17) {
                    g.drawImage(wallLeft, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 18) {
                    g.drawImage(roofTopRight, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 19) {
                    g.drawImage(roofRight, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 20) {
                    g.drawImage(roofFrontRight, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 21) {
                    g.drawImage(wallRight, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 22) {
                    g.drawImage(door, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 23) {
                    g.drawImage(wallMidOn, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }else if (mapArrayClone[row][col] == 24) {
                    g.drawImage(wallMidOff, col * tileSize + offsetX, row * tileSize + offsetY, tileSize, tileSize, null);
                }

            }
        }
    }
}