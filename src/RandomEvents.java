import java.util.Random;

public class RandomEvents
{
    static Random random = new Random();
    public static int monsterSpawnChance = 8; // Chance of monster spawning per roll
    public static int chestSpawnChance = 17; // Chance of chest spawning per roll

    public static boolean chestAvailable = false;
    public static boolean inCombat = false;


    public static void generateEvent() {
        int randomNumber = random.nextInt(100); // Generates random number between 0-99

        if (randomNumber < monsterSpawnChance) {
            spawnMonster();
            inCombat = true;
        } else if (randomNumber < monsterSpawnChance + chestSpawnChance) {
            spawnChest();
            chestAvailable = true;
        }

    }

    public static void spawnMonster() {
        System.out.println("A monster appeared!");
    }

    public static void spawnChest() {
        System.out.println("You have found a chest!");
    }
}
