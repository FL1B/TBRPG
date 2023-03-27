package Map;
import Game.RandomEvents;

public class PlayerPos {
    public static int x = 345;
    public static int y = 345;


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public static void setX(int x) {
        PlayerPos.x += x;
    }

    public static void setY(int y) {
        PlayerPos.y += y;
    }


    public static void move(String input) {
        char direction = input.charAt(0);

        switch (direction) {
            case 'n':
                System.out.println("You walk north.");
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setY(1);
                break;
            case 's':
                System.out.println("You walk south.");
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setY(-1);
                break;
            case 'e':
                System.out.println("You walk east.");
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(1);
                break;
            case 'w':
                System.out.println("You walk west.");
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(-1);
                break;
            default:
                System.out.println("Invalid direction: " + direction);
        }
    }
}
