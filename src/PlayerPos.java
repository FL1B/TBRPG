public class PlayerPos
{
    public static int northCount = 0;
    public static int southCount = 0;
    public static int eastCount = 0;
    public static int westCount = 0;

    public static void moveNorth() {
        System.out.println("You walk north.");
        northCount++;
        southCount--;
    }

    public static void moveWest() {
        System.out.println("You walk west.");
        westCount++;
        eastCount--;
    }

    public static void moveEast() {
        System.out.println("You walk east.");
        eastCount++;
        westCount--;
    }

    public static void moveSouth() {
        System.out.println("You walk south.");
        southCount++;
        northCount--;
    }
}
