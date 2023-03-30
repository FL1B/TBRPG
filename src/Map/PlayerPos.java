package Map;
import Game.RandomEvents;

public class PlayerPos {
    public static int x = 0;
    public static int y = 0;
    public static int maxX = 1000;
    public static int maxY = 1000;
    public static int minX = maxX-(maxX*2);
    public static int minY = maxY-(maxY*2);


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public static void setX(int x) {
        if (PlayerPos.x > maxX) {
            PlayerPos.x = maxX;
        } else if (PlayerPos.x < minX) {
            PlayerPos.x = minX;
        } else {
            PlayerPos.x += x;
        }
    }

    public static void setY(int y) {
        if (PlayerPos.y > maxY) {
            PlayerPos.y = maxY;
        } else if (PlayerPos.y < minY) {
            PlayerPos.y = minY;
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
                setY(100);
                break;
            case 's':
                System.out.println("You walk south.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setY(-100);
                break;
            case 'e':
                System.out.println("You walk east.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(-100);
                break;
            case 'w':
                System.out.println("You walk west.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(100);
                break;
            default:
                System.out.println("Invalid direction: " + direction);
        }
    }
}
