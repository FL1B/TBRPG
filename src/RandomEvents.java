import java.util.Random;

public class RandomEvents
{
    static Random random = new Random();
    public static int monsterSpawnChance = 10; // Percentage chance of monster spawning per roll
    public static int chestSpawnChance = 20; // Percentage chance of chest spawning per roll


    public static void generateEvent() {
        int randomNumber = random.nextInt(100); // generates random number between 0-99

        if (randomNumber < monsterSpawnChance) {
            spawnMonster();
        } else if (randomNumber < monsterSpawnChance + chestSpawnChance) {
            spawnChest();
        } else {
            System.out.println("Nothing interesting happened");
        }

    }

    public static void spawnMonster() {
        System.out.println("A monster appeared!");
    }

    public static void spawnChest() {
        System.out.println("You have found a chest!");
    }
}
