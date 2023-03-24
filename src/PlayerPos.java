public class PlayerPos
{
    public static int x = 0;
    public static int y = 0;


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



    public static void moveNorth() {
        System.out.println("You walk north.");
        RandomEvents.generateEvent();
        RandomEvents.monsterSpawnChance ++;
        RandomEvents.chestSpawnChance ++;
        setY(1);
    }

    public static void moveWest() {
        System.out.println("You walk west.");
        RandomEvents.generateEvent();
        RandomEvents.monsterSpawnChance ++;
        RandomEvents.chestSpawnChance ++;
        setX(-1);
    }

    public static void moveEast() {
        System.out.println("You walk east.");
        RandomEvents.generateEvent();
        RandomEvents.monsterSpawnChance ++;
        RandomEvents.chestSpawnChance ++;
        setX(1);
    }

    public static void moveSouth() {
        System.out.println("You walk south.");
        RandomEvents.generateEvent();
        RandomEvents.monsterSpawnChance ++;
        RandomEvents.chestSpawnChance ++;
        setY(-1);
    }

}
