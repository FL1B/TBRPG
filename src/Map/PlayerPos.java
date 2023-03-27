package Map;
import Game.RandomEvents;

public class PlayerPos {
    public static int x = 380;
    public static int y = 380;


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public static void setX(int x) {
        if (PlayerPos.x == 760) {
            PlayerPos.x = 760;
        } else if (PlayerPos.x == 10) {
            PlayerPos.x = 10;
        } else {
            PlayerPos.x += x;
        }
    }

    public static void setY(int y) {
        if (PlayerPos.y == 760) {
            PlayerPos.y = 760;
        } else if (PlayerPos.y == 10) {
            PlayerPos.y = 10;
        } else {
            PlayerPos.y += y;
        }
    }


    public static void move(String input) {
        char direction = input.charAt(0);

        switch (direction) {
            case 'n':
                System.out.println("You walk north.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setY(-10);
                break;
            case 's':
                System.out.println("You walk south.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setY(10);
                break;
            case 'e':
                System.out.println("You walk east.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(10);
                break;
            case 'w':
                System.out.println("You walk west.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(-10);
                break;
            default:
                System.out.println("Invalid direction: " + direction);
        }
    }
}
