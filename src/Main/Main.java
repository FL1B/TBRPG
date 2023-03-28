package Main;

import Game.TextRPG;
import Map.Map;
import Player.Character;

import javax.swing.*;
import java.util.Scanner;

public class Main
{
    private static void updateWindow(TextRPG game, Map map) {
        System.out.println(
                "Class " + game.chooseCharacter().getPlayerClassName() + " " + game.currentCharacter.getName() + "lvl" + game.currentCharacter.getLvl() + "\n" +
                        "HP " + game.currentCharacter.getCurrentHp() + "\n" +
                        "Mana " + game.currentCharacter.getCurrentMana() + "\n" +
                        "Str " + game.currentCharacter.getStrength() + "\n" +
                        "Int " + game.currentCharacter.getIntelligence() + "\n"
        );

        game.firstMenu();

        while (true) {
            game.movePlayer();
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
        window.setBounds(345, 345, 800, 820);
        window.setTitle("TextRPG");
        window.getContentPane().add(map);
        window.setVisible(true);

        updateWindow(game, map);


    }
}
