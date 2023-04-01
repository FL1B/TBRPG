package Map;

import javax.swing.*;
import java.io.*;
import java.util.Random;
import Main.Main;

public class RandomGenerator {
    private static int[][] mapArray;

    public static int top = 0;
    public static int bottom = Main.mapSize-1;
    public static int left = 0;
    public static int right = Main.mapSize-1;

    public static int center = Main.mapSize/2;
    public static int roadSize = 10;


    public static void generate(int[][] mapArray2, PrintWriter writer) {
        Random rand = new Random();
        System.out.println("Generating map...");
        for (int row = 0; row < mapArray2.length; row++) {
            int prevRand = rand.nextInt(3);
            for (int col = 0; col < mapArray2[row].length; col++) {
                int randomNumber = rand.nextInt(3);
                if (row == top || col == left || row == bottom || col == right) {
                    mapArray2[row][col] = 1;
                } else if (randomNumber == 0 || randomNumber == 2) {
                    if (row <= center-roadSize && col <= center-roadSize ||
                            row >= center+roadSize && col >= center+roadSize ||
                            row <= center-roadSize && col >= center+roadSize ||
                            row >= center+roadSize && col <= center-roadSize) {
                        mapArray2[row][col] = 1;
                    } else {
                        mapArray2[row][col] = 0;
                    }
                }
            }
            //printMapArray(mapArray2);
        }
        System.out.println("Done!");
        saveMapArray(mapArray2, writer);
    }
    //Printer mapArray i konsoll
    public static void printMapArray(int[][] mapArray2) {
        for (int row = 0; row < mapArray2.length; row++) {
            for (int col = 0; col < mapArray2[row].length; col++) {
                System.out.print(mapArray2[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void saveMapArray(int[][] mapArray2, PrintWriter writer) {
        for (int row = 0; row < mapArray2.length; row++) {
            for (int col = 0; col < mapArray2[row].length; col++) {
                writer.print(mapArray2[row][col]);
                if (col < mapArray2[row].length - 1) {
                    writer.print(",");
                }
            }
            writer.println();
        }
        writer.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[][] mapArray2 = new int[100][100];
        PrintWriter writer = new PrintWriter("src/Map/noe.txt");
        generate(mapArray2, writer);
        //saveMapArray(mapArray2, writer);
    }
}
