public class PlayerPos
{
    public static int x = 0;
    public static int y = 0;

    public static void moveNorth() {
        System.out.println("You walk north.");
        x++;
    }

    public static void moveWest() {
        System.out.println("You walk west.");
        y--;
    }

    public static void moveEast() {
        System.out.println("You walk east.");
        y++;
    }

    public static void moveSouth() {
        System.out.println("You walk south.");
        x--;
    }
}
