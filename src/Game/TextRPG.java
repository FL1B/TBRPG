package Game;

import Map.Biomes;
import Map.PlayerPos;
import Map.Map;
import PlayerClass.PlayerClass;
import PlayerClass.PlayerClassFactory;
import PlayerClass.WarriorFactory;
import PlayerClass.MageFactory;
import PlayerClass.RogueFactory;
import Player.Character;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class TextRPG implements KeyListener
{
    Scanner scanner = new Scanner(System.in);
    boolean askAgain = true;
    public PlayerClass currentClass;
    public Character currentCharacter;


    public PlayerClass chooseCharacter(Map map) {
        System.out.println("Welcome to TextRPG");
        System.out.println("Choose a character");
        System.out.println("w => warrior");
        System.out.println("m => mage");
        System.out.println("r => rogue");

        String classSelect = scanner.nextLine();
        System.out.println("Choose a name");
        String nameSelect = scanner.nextLine();

        switch (classSelect.toLowerCase()) {
            case "w":
                PlayerClassFactory warriorFactory = new WarriorFactory();
                PlayerClass warrior = warriorFactory.createPlayerClass();
                currentClass = warrior;
                Character warriorCharacter = new Character(nameSelect,1, 10000, warrior.getHealthPoints(), warrior.getMana(), warrior.getIntelligence(), warrior.getStrength());
                currentCharacter = warriorCharacter;
                map.setPlayerImg(currentClass.getImage());
                return warrior;
            case "m":
                PlayerClassFactory mageFactory = new MageFactory();
                PlayerClass mage = mageFactory.createPlayerClass();
                currentClass = mage;
                Character mageCharacter = new Character(nameSelect,1, 10000, mage.getHealthPoints(), mage.getMana(), mage.getIntelligence(), mage.getStrength());
                currentCharacter = mageCharacter;
                map.setPlayerImg(currentClass.getImage());
                return mage;
            case "r":
                PlayerClassFactory rogueFactory = new RogueFactory();
                PlayerClass rogue = rogueFactory.createPlayerClass();
                currentClass = rogue;
                Character rogueCharacter = new Character(nameSelect,1, 10000, rogue.getHealthPoints(), rogue.getMana(), rogue.getIntelligence(), rogue.getStrength());
                currentCharacter = rogueCharacter;
                map.setPlayerImg(currentClass.getImage());
                return rogue;
        }
        return null;

    }
    public void firstMenu() {
        System.out.println("Type 'n' to move north");
        System.out.println("Type 'w' to move west");
        System.out.println("Type 'e' to move east");
        System.out.println("Type 's' to move south");
    }

    public void movePlayer(String input) {
        do {

            switch (input) {
                case "s":
                    PlayerPos.move(input);
                    break;
                case "d":
                    PlayerPos.move(input);
                    break;
                case "a":
                    PlayerPos.move(input);
                    break;
                case "w":
                    PlayerPos.move(input);
                    break;
                case "h":
                    listOfCommands();
                    break;
                case "c":
                    Biomes.navigate();
                    break;
                case "l":
                    System.out.println(Biomes.getCurrentBiome());
                    break;
                case "exit":
                    askAgain = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    System.out.println("Type 'help' for list of commands");
            }
        } while (false);
    }

    public void listOfCommands() {
        System.out.println("This is the list of commands:");
        System.out.println("Type 'n' to move north.");
        System.out.println("Type 'w to move west.");
        System.out.println("Type 'e' to move east.");
        System.out.println("Type 's' to move south.");
        System.out.println("Type 'l' to look around.");
        System.out.println("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_W) {
            movePlayer("w");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
