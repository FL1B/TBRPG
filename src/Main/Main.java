package Main;

import Game.TextRPG;
import Map.Map;
import Player.Character;
import Map.PlayerPos;
import input.MyKeyHandler;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.plaf.basic.BasicTreeUI.KeyHandler;
import java.awt.*;
import java.sql.Connection;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main
{
    private static void updateWindow(TextRPG game, Map map, JFrame window, PlayerPos playerPos, MyKeyHandler keyHandler) {
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

    private static String readUserInput() {
        // read user input from console
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static void main(String[] args) throws InterruptedException {
        Connection connection = Game.Database.getConnection();
        TextRPG game = new TextRPG();
        JFrame window = new JFrame();
        Map map = new Map(window);
        PlayerPos playerPos = new PlayerPos(map);
        MyKeyHandler keyHandler = new MyKeyHandler();


        updateWindow(game, map, window, playerPos, keyHandler);
    }
}
