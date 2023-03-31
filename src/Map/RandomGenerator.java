package Map;

import javax.swing.*;
import java.io.*;
import java.util.Random;

public class RandomGenerator {
    private static int[][] mapArray;

    public RandomGenerator() {
        try {
            loadMapArray("src/Map/mapArray.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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

    public static void generate(int[][] mapArray2) {
        Random rand = new Random();
        for (int row = 0; row < mapArray2.length; row++) {
            for (int col = 0; col < mapArray2[row].length; col++) {
                int randomNumber = rand.nextInt(3);
                if (row == 0 || col == 0 || row == 99 || col == 99) {
                    mapArray2[row][col] = 1;
                } else if (randomNumber == 0 || randomNumber == 2) {
                    mapArray2[row][col] = randomNumber;
                } else {
                    mapArray2[row][col] = 0;
                }
            }
        }
        printMapArray(mapArray2);
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
        generate(mapArray2);
        saveMapArray(mapArray2, writer);
    }
}
