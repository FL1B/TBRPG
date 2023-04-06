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
        generateCity(mapArrayOriginal, writer);
    }

    public static void generateCity(int[][] mapArrayOriginal, PrintWriter writer) throws IOException {
        Random rand = new Random();
        System.out.println("Generating city...");
        for (int row = 0; row < mapArrayOriginal.length; row++) {
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                int randomNumber = rand.nextInt(12);
//#######################################Horisontal##################################
                    // ################## Roof_top ##################################
                if (row == center-roadSize && col <= center-roadSize || // Left_top
                        row == center-roadSize && col >= center+roadSize || //Right_top
                        row == center+roadSize-5 && col <= center-roadSize || //Left_bottom
                        row == center+roadSize-5 && col >= center+roadSize) { //Right_bottom
                    if (col == 0 || col == right) { //Barri
                        mapArrayOriginal[row][col] = 1;
                    } else if (col == 1 || col == center+roadSize) { //Roof_top_left
                        mapArrayOriginal[row][col] = 14;
                    } else if (col == center-roadSize || col == right-1) { //Roof_top_right
                        mapArrayOriginal[row][col] = 18;
                    } else { // Roof_top_mid
                        mapArrayOriginal[row][col] = 10;
                    }
                    // ################## Roof_mid ##################################
                } else if (row == center-roadSize+1 && col <= center-roadSize || // Left_top
                            row == center-roadSize+1 && col >= center+roadSize || // Right_top
                            row == center+roadSize-4 && col <= center-roadSize ||// Left_top
                            row == center+roadSize-4 && col >= center+roadSize) { // Right_bottom
                    if (col == 0 || col == right) { //Barri
                        mapArrayOriginal[row][col] = 1;
                    } else if (col == 1 || col == center+roadSize) { //Roof_left
                        mapArrayOriginal[row][col] = 15;
                    } else if (col == center-roadSize || col == right-1) { //Roof_right
                        mapArrayOriginal[row][col] = 19;
                    } else { //Roof_mid
                        mapArrayOriginal[row][col] = 11;
                    }
                    // ################## Roof_front ##################################
                } else if (row == center-roadSize+2 && col <= center-roadSize || // Left_top
                            row == center-roadSize+2 && col >= center+roadSize || // Right_top
                            row == center+roadSize-3 && col <= center-roadSize || // Left_bottom
                            row == center+roadSize-3 && col >= center+roadSize) { // Right_bottom
                    if (col == 0 || col == right) { //Barri
                        mapArrayOriginal[row][col] = 1;
                    } else if (col == 1 || col == center+roadSize) { //Roof_front_left
                        mapArrayOriginal[row][col] = 16;
                    } else if (col == center-roadSize || col == right-1) { //Roof_front_right
                        mapArrayOriginal[row][col] = 20;
                    } else { //Roof_front
                        mapArrayOriginal[row][col] = 12;
                    }
                    // ################## Wall ##################################
                } else if (row >= center-roadSize+3 && col <= center-roadSize && row <= center-roadSize+5 || // Left_top
                            row >= center+roadSize-2 && col <= center-roadSize && row <= center+roadSize || // Left_bottom
                            row >= center-roadSize+3 && col >= center+roadSize && row <= center-roadSize+5 || // Right_top
                        row >= center+roadSize-2 && col >= center+roadSize && row <= center+roadSize ) {
                    if (col == 0 || col == right) { //Barri
                        mapArrayOriginal[row][col] = 1;
                    } else if (col == 1 || col == center+roadSize) { //Wall_left
                        mapArrayOriginal[row][col] = 17;
                    } else if (col == center-roadSize || col == right-1) { //Wall_right
                        mapArrayOriginal[row][col] = 21;
                    } else if (row == center-roadSize+5 && randomNumber == 0 || row == center+roadSize && randomNumber == 1) {
                        mapArrayOriginal[row][col] = 22;
                    } else { //Wall_mid
                        if (randomNumber == 3 || randomNumber == 4) {
                            mapArrayOriginal[row][col] = 23;
                        } else if (randomNumber == 5 || randomNumber == 6) {
                            mapArrayOriginal[row][col] = 24;
                        } else {
                            mapArrayOriginal[row][col] = 13;
                        }

                    }
////#######################################Vertical##################################
                    // ################## Roof_left ##################################
                } else if (col == center-roadSize+1 && row <= center-roadSize-1 || // Left_top
                            col == center+roadSize-3 && row <= center-roadSize-1 || // Right_top
                            col == center-roadSize+1 && row >= center+roadSize+1 || // Left_bottom
                            col == center+roadSize-3 && row >= center+roadSize+1) { //Right_bottom
                    if (row == 0 || row == bottom){
                        mapArrayOriginal[row][col] = 1; // Barri
                    } else if (row == center-roadSize-1 || row == center+roadSize-2 || row == bottom-1) {
                        mapArrayOriginal[row][col] = 16; // Roof_front_left
                    } else if (row == 1 || row == center+roadSize+1 || row == top+1) {
                        mapArrayOriginal[row][col] = 14; //Roof_top_left
                    }else {
                        mapArrayOriginal[row][col] = 15; // Roof_left
                    }
                    // ################## Roof_mid ##################################
                } else if (col == center-roadSize+2 && row <= center-roadSize-1 || // Left_top
                            col == center+roadSize-2 && row <= center-roadSize-1 || // Right_top
                            col == center-roadSize+2 && row >= center+roadSize+1 || // Left_bottom
                            col == center+roadSize-2 && row >= center+roadSize+1) { //Right_bottom
                    if (row == 0 || row == bottom){
                        mapArrayOriginal[row][col] = 1; // Barri
                    } else if (row == center-roadSize-1 || row == bottom-1) {
                        mapArrayOriginal[row][col] = 12; // Roof_front_mid
                    } else if (row == center+roadSize+1 || row == top+1) {
                        mapArrayOriginal[row][col] = 10; //Roof_top_mid
                    } else {
                        mapArrayOriginal[row][col] = 11; // Roof_mid
                    }
                    // ################## Roof_right ##################################
                } else if (col == center-roadSize+3 && row <= center-roadSize-1 ||
                            col == center+roadSize-1 && row <= center-roadSize-1 ||
                            col == center-roadSize+3 && row >= center+roadSize+1 ||
                            col == center+roadSize-1 && row >= center+roadSize+1) {
                    if (row == 0 || row == bottom){
                        mapArrayOriginal[row][col] = 1; // Barri
                    } else if (row == center-roadSize-1 || row == bottom-1) {
                        mapArrayOriginal[row][col] = 20; // Roof_front_right
                    } else if (row == center+roadSize+1 || row == top+1) {
                        mapArrayOriginal[row][col] = 18;
                    } else {
                        mapArrayOriginal[row][col] = 19; // Roof_right
                    }
                    // ################## Wall ##################################
                } else if (col >= center-roadSize+1 && col <= center-roadSize+3 && row >= center-roadSize-1 && row <= center-roadSize+2 ||
                            col <= center+roadSize-1 && col >= center+roadSize-3 && row >= center-roadSize-1 && row <= center-roadSize+2) {
                    if (col == center-roadSize+1 || col == center+roadSize-3){
                        mapArrayOriginal[row][col] = 17; //Wall_left
                    } else if (col == center-roadSize+3 || col == center+roadSize-1) {
                        mapArrayOriginal[row][col] = 21; // Wall_right
                    } else {
                        mapArrayOriginal[row][col] = 13; // Wall_mid
                    }
                }
            }
        }
        System.out.println("Done!");
        randomizeCity(mapArrayOriginal, writer);
    }

    public static void randomizeCity(int[][] mapArrayOriginal, PrintWriter writer) throws IOException {
        Random rand = new Random();
        System.out.println("Randomizing city...");
        for (int row = 0; row < mapArrayOriginal.length; row++) {
            for (int col = 0; col < mapArrayOriginal[row].length; col++) {
                int randomNumber = rand.nextInt(3);
                if (randomNumber == 0 && mapArrayOriginal[row][col] == 10 && !(row <= center-roadSize-1 || row >= center+roadSize)) {
                    if (!(row >= bottom-5) && !(row <= top+5) && !(col <= left + 5) && !(col >= right-5)) {

                        //setter midterste til gress
                        mapArrayOriginal[row][col] = 0;
                        mapArrayOriginal[row + 1][col] = 0;
                        mapArrayOriginal[row + 2][col] = 0;
                        mapArrayOriginal[row + 3][col] = 0;
                        mapArrayOriginal[row + 4][col] = 0;
                        mapArrayOriginal[row + 5][col] = 0;

                        //setter venstre side bygg
                        mapArrayOriginal[row][col-1] = 18;
                        mapArrayOriginal[row + 1][col-1] = 19;
                        mapArrayOriginal[row + 2][col-1] = 20;
                        mapArrayOriginal[row + 3][col-1] = 21;
                        mapArrayOriginal[row + 4][col-1] = 21;
                        mapArrayOriginal[row + 5][col-1] = 21;

                        //setter høyre side bygg
                        mapArrayOriginal[row][col+1] = 14;
                        mapArrayOriginal[row + 1][col+1] = 15;
                        mapArrayOriginal[row + 2][col+1] = 16;
                        mapArrayOriginal[row + 3][col+1] = 17;
                        mapArrayOriginal[row + 4][col+1] = 17;
                        mapArrayOriginal[row + 5][col+1] = 17;

                    }
                } else if (randomNumber == 0 && mapArrayOriginal[row][col] == 15 && (row <= center-roadSize-1 || row >= center+roadSize)) {
                    if (!(row >= bottom-5) && !(row <= top+5) && !(col <= left + 5) && !(col >= right-5)) {

                        //setter midterste til gress
                        mapArrayOriginal[row][col] = 0;
                        mapArrayOriginal[row][col+1] = 0;
                        mapArrayOriginal[row][col+2] = 0;

                        //setter nedre side bygg
                        mapArrayOriginal[row-1][col] = 16;
                        mapArrayOriginal[row-1][col+1] = 12;
                        mapArrayOriginal[row-1][col+2] = 20;

                        //setter øvre side bygg
                        mapArrayOriginal[row+1][col] = 14;
                        mapArrayOriginal[row+1][col+1] = 10;
                        mapArrayOriginal[row+1][col+2] = 18;

                    }
                }
            }
        }
        printMapArray(mapArrayOriginal);
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

//||
//                            row >= center+roadSize && col >= center+roadSize ||
//                            row <= center-roadSize && col >= center+roadSize ||
//                            row >= center+roadSize && col <= center-roadSize) {
