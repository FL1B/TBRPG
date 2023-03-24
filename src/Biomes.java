import java.util.ArrayList;

public class Biomes
{



    public static ArrayList<String> northBiome = new ArrayList<>();
    public static ArrayList<String> southBiome = new ArrayList<>();
    public static ArrayList<String> eastBiome = new ArrayList<>();
    public static ArrayList<String> westBiome = new ArrayList<>();


    static {

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
        if (PlayerPos.getX() == 0 && PlayerPos.getY() == 1) {
            return northBiome.get(0);
        } else if (PlayerPos.getX() == 0 && PlayerPos.getY() == 2) {
            return northBiome.get(1);
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == 3) {
            return northBiome.get(2);
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == -1) {
            return southBiome.get(0);
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == -2) {
            return southBiome.get(1);
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == -3) {
            return southBiome.get(2);
        }else if (PlayerPos.getX() == 1 && PlayerPos.getY() == 0) {
            return eastBiome.get(0);
        }else if (PlayerPos.getX() == 2 && PlayerPos.getY() == 0) {
            return eastBiome.get(1);
        }else if (PlayerPos.getX() == 3 && PlayerPos.getY() == 0) {
            return eastBiome.get(2);
        }else if (PlayerPos.getX() == -1 && PlayerPos.getY() == 0) {
            return westBiome.get(0);
        }else if (PlayerPos.getX() == -2 && PlayerPos.getY() == 0) {
            return westBiome.get(1);
        }else if (PlayerPos.getX() == -3 && PlayerPos.getY() == 0) {
            return westBiome.get(2);
        }else {
            return "error bitch!";
        }
    }
}
