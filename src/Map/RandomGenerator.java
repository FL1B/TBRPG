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


    public static void generate(int[][] mapArrayOriginal, PrintWriter writer) throws IOException {
        Random rand = new Random();
        System.out.println("Generating map...");
        for (int row = 0; row < mapArrayOriginal.length; row++) {
            int prevRand = rand.nextInt(3);
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                int randomNumber = rand.nextInt(4);
                if (row == top || col == left || row == bottom || col == right) {
                    mapArrayOriginal[row][col] = 1;
                } else if (randomNumber == 0 || randomNumber == 2 || randomNumber == 3) {
                    if (row <= center-roadSize && col <= center-roadSize ||
                            row >= center+roadSize && col >= center+roadSize ||
                            row <= center-roadSize && col >= center+roadSize ||
                            row >= center+roadSize && col <= center-roadSize) {
                        mapArrayOriginal[row][col] = randomNumber;
                    } else {
                        mapArrayOriginal[row][col] = 0;
                        if (randomNumber == 0){
                            mapArrayOriginal[row][col] = 0;
                        } else if (randomNumber == 3) {
                            mapArrayOriginal[row][col] = 3;
                        }
                    }
                }
            }
            //printMapArray(mapArrayOriginal);
        }
        System.out.println("Done!");
        saveMapArray(mapArrayOriginal, writer);
    }
    //Printer mapArray i konsoll
    public static void printMapArray(int[][] mapArrayOriginal) {
        for (int row = 0; row < mapArrayOriginal.length; row++) {
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                System.out.print(mapArrayOriginal[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void saveMapArray(int[][] mapArrayOriginal, PrintWriter writer) throws IOException {
        for (int row = 0; row < mapArrayOriginal.length; row++) {
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                writer.print(mapArrayOriginal[row][col]);
                if (col < mapArrayOriginal[row].length - 1) {
                    writer.print(",");
                }
            }
            writer.println();
        }
        writer.close();
        cloneFile();
    }

    public static void cloneFile() throws IOException {
        File originalFile = new File("src/Map/map.txt");
        File cloneFile = new File("src/Map/map_copy.txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(originalFile);
            os = new FileOutputStream(cloneFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            is.close();
            os.close();
        }
    }

    

    public static void main(String[] args) throws IOException {
        //int[][] mapArrayOriginal = new int[100][100];
        //PrintWriter writer = new PrintWriter("src/Map/map.txt");
        //generate(mapArrayOriginal, writer);
        cloneFile();

    }
}
