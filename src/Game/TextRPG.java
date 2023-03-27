package Game;

import Map.Biomes;
import Map.PlayerPos;
import Map.Map;
import PlayerClass.PlayerClass;
import PlayerClass.PlayerClassFactory;
import PlayerClass.WarriorFactory;

import java.util.Scanner;

public class TextRPG
{
    Scanner scanner = new Scanner(System.in);
    boolean askAgain = true;
    public PlayerClass currentClass;


    public PlayerClass chooseCharacter() {
        System.out.println("Welcome to TextRPG");
        System.out.println("Choose a character");
        System.out.println("w => warrior");
        System.out.println("m => mage");



        String input = scanner.nextLine();

        switch (input.toLowerCase()) {
            case "w":
                PlayerClassFactory warriorFactory = new WarriorFactory();
                PlayerClass warrior = warriorFactory.createPlayerClass();
                currentClass = warrior;
                return warrior;
        }
        return null;

    }
    public void firstMenu() {
        System.out.println("Type 'n' to move north");
        System.out.println("Type 'w' to move west");
        System.out.println("Type 'e' to move east");
        System.out.println("Type 's' to move south");
    }

    public void movePlayer() {
        do {
            String input = scanner.nextLine();

            switch (input) {
                case "n":
                    PlayerPos.move(input);
                    break;
                case "w":
                    PlayerPos.move(input);
                    break;
                case "e":
                    PlayerPos.move(input);
                    break;
                case "s":
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
        } while (askAgain);
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
}
