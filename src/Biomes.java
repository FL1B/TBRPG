import java.util.ArrayList;

public class Biomes
{



    public static ArrayList<String> northBiome = new ArrayList<String>();
    public static ArrayList<String> southBiome = new ArrayList<>();
    public static ArrayList<String> eastBiome = new ArrayList<>();
    public static ArrayList<String> westBiome = new ArrayList<>();


    public Biomes() {

        northBiome.add("Snowy Mountains");
        northBiome.add("Frozen Tundra");
        northBiome.add("Taiga Forest");
        southBiome.add("Tropical Jungle");
        southBiome.add("Desert Oasis");
        southBiome.add("Savanna Plains");
        eastBiome.add("Mystic River");
        eastBiome.add("Enchanted Forest");
        eastBiome.add("Volcano");
        westBiome.add("Island Paradise");
        westBiome.add("Coral Reef");
        westBiome.add("Deep Ocean");
    }

    public static void navigate() {
        if (PlayerInv.compass == true) {
            System.out.println("Your current position is:");
            System.out.println(PlayerPos.x + " X");
            System.out.println(PlayerPos.y + " Y");
        } else if (PlayerPos.x >= 3){
            System.out.println("It feels like im further north");
        } else if (PlayerPos.x <= -3){
            System.out.println("It feels like im further south");
        } else if (PlayerPos.y >= -3){
            System.out.println("It feels like im further west");
        } else if (PlayerPos.y >= 3){
            System.out.println("It feels like im further east");
        } else {
            System.out.println("It's hard to distinguish where i am without a compass.");
        }
    }

    public static String getCurrentBiome() {
        int maxCount = Math.max(Math.max(
                PlayerPos.northCount,
                PlayerPos.southCount),
                Math.max(PlayerPos.eastCount,
                        PlayerPos.westCount));
        String currentBiome;

        if (maxCount == PlayerPos.northCount) {
            currentBiome = northBiome.get(1);
        } else if (maxCount == PlayerPos.southCount) {
            currentBiome = southBiome.get(1);
        } else if (maxCount == PlayerPos.eastCount) {
            currentBiome = eastBiome.get(1);
        } else {
            currentBiome = westBiome.get(1);
        }
        return currentBiome;
    }

    public void newGetCurrentBiome() {
        switch (PlayerPos.northCount) {
            case 1:
                return ""
        }
    }
}
