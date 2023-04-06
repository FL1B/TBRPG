package Main;

import Game.TextRPG;
import Map.Map;
import Map.PlayerPos;
import database.Database;
import input.MyKeyHandler;
import Map.RandomGenerator;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Main
{
    public static int mapSize = 200;
    public static int zoom = 35;
    private static void updateWindow(TextRPG game, Map map, JFrame window, PlayerPos playerPos, MyKeyHandler keyHandler, PrintWriter writer, RandomGenerator randomGenerator) throws IOException {

        int[][] mapArrayOriginal = new int[mapSize][mapSize];
        randomGenerator.generate(mapArrayOriginal, writer);

        Database.getConnection();

        game.chooseCharacter(map);

        map.setPlayerPos();
        System.out.println(
                        game.currentCharacter.getName() +  " the " + game.currentClass.getPlayerClassName() + " lvl " + game.currentCharacter.getLvl() + "\n" +
                        "HP " + game.currentCharacter.getMaxHealth() + "\n" +
                        "Mana " + game.currentCharacter.getCurrentMana() + "\n" +
                        "Str " + game.currentCharacter.getStrength() + "\n" +
                        "Int " + game.currentCharacter.getIntelligence() + "\n"
        );

        playerPos.setMap(map);

        window.addKeyListener(keyHandler);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1100 , 1100);
        window.setTitle("TextRPG");
        window.getContentPane().add(map);
        window.setVisible(true);
        window.setResizable(true);
        game.firstMenu();

        while (true) {
            map.repaint();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        TextRPG game = new TextRPG();
        JFrame window = new JFrame();
        Map map = new Map(window);
        RandomGenerator randomGenerator = new RandomGenerator();
        PrintWriter writer = new PrintWriter("src/Map/map.txt");
        PlayerPos playerPos = new PlayerPos(map);
        MyKeyHandler keyHandler = new MyKeyHandler();


        updateWindow(game, map, window, playerPos, keyHandler, writer, randomGenerator);
    }
}
