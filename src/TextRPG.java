import java.util.Scanner;

public class TextRPG
{
    Scanner scanner = new Scanner(System.in);
    boolean askAgain = true;

    public void firstMenu() {
        System.out.println("Welcome to TextRPG");
        System.out.println("Type 'move north' to move north");
        System.out.println("Type 'move west' to move west");
        System.out.println("Type 'move east' to move east");
        System.out.println("Type 'move south' to move south");
    }

    public void movePlayer() {
        do {
            String input = scanner.nextLine();

            switch (input.toLowerCase()) {
                case "move north":
                    PlayerPos.moveNorth();
                    break;
                case "move west":
                    PlayerPos.moveWest();
                    break;
                case "move east":
                    PlayerPos.moveEast();
                    break;
                case "move south":
                    PlayerPos.moveSouth();
                    break;
                case "help":
                    listOfCommands();
                    break;
                case "scope location":
                    Biomes.navigate();
                    break;
                case "look around":
                    System.out.println(Biomes.getCurrentBiome());
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    System.out.println("Type 'help' for list of commands");
            }
        } while (askAgain);
    }

    public void listOfCommands() {
        System.out.println("This is the list of commands:");
        System.out.println("Type 'move north' to move north.");
        System.out.println("Type 'move west' to move west.");
        System.out.println("Type 'move east' to move east.");
        System.out.println("Type 'move south' to move south.");
        System.out.println("Type 'look around' to look around.");
        System.out.println("");
    }
}
