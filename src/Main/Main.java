package Main;

import Game.TextRPG;
import Map.Map;

import javax.swing.*;
import java.util.Scanner;

public class Main
{
    private static void updateWindow(TextRPG game, Map map) {
        System.out.println(
                "Class " + game.chooseCharacter().getPlayerClassName() + "\n" +
                        "HP " + game.currentClass.getHealthPoints() + "\n" +
                        "Str " + game.currentClass.getStrength() + "\n" +
                        "Mana " + game.currentClass.getMana() + "\n" +
                        "Int " + game.currentClass.getIntelligence() + "\n"
        );

        while (true) {
            game.firstMenu();
            game.movePlayer();
            System.out.println("Updating window");
            map.repaint();
        }
    }

    private static String readUserInput() {
        // read user input from console
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static void main(String[] args) throws InterruptedException {
        TextRPG game = new TextRPG();
        JFrame window = new JFrame();
        Map map = new Map();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(345, 345, 1000, 1000);
        window.setTitle("TextRPG");
        window.getContentPane().add(map);
        window.setVisible(true);

        updateWindow(game, map);


    }
}
