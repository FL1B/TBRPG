package Map;
import Game.RandomEvents;

public class PlayerPos {
    public static int x = 5;
    public static int y = 5;
    public static int maxX = 8;
    public static int maxY = 8;
    public static int minX = maxX-maxX;
    public static int minY = maxY-maxY;
    public static int newX;
    public static int newY;
    public static Map map;

    public void setMap(Map map) {
        this.map = map;
    }

    public PlayerPos(Map map) {
        this.map = map;
    }


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }


    public static void setX(int x) {
        if (PlayerPos.x >= maxX) {
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
                for (int row = 0; row < map.mapArray.length; row++) {
                    for (int col = 0; col < map.mapArray[row].length; col++) {
                        if (map.mapArray[row][col] == 8) {
                            newY = row + 1;

                        }
                    }
                    if (newY > maxY && map.mapArray[newY][getX()] == 1) {
                        setY(-1);
                    }else {
                        setY(1);
                    }
                    break;
                }
                break;
            case 's':
                System.out.println("You walk south.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setY(-1);
                break;
            case 'e':
                System.out.println("You walk east.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(-1);
                break;
            case 'w':
                System.out.println("You walk west.");
                System.out.println("X " + PlayerPos.x);
                System.out.println("Y " + PlayerPos.y);
                RandomEvents.generateEvent();
                RandomEvents.monsterSpawnChance ++;
                RandomEvents.chestSpawnChance ++;
                setX(1);
                break;
            default:
                System.out.println("Invalid direction: " + direction);
        }
    }
}
