package Map;

import Map.PlayerPos;
import Player.PlayerInv;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Biomes extends JComponent
{

    public static HashMap<String, String> biomesMap = new HashMap<>();

    public static ArrayList<String> northBiome = new ArrayList<>();
    public static ArrayList<String> southBiome = new ArrayList<>();
    public static ArrayList<String> eastBiome = new ArrayList<>();
    public static ArrayList<String> westBiome = new ArrayList<>();


    static {

        biomesMap.put("north1","Snowy Mountains");
        biomesMap.put("north2","Frozen Tundra");
        biomesMap.put("north3","Taiga Forest");
        biomesMap.put("south1","Tropical Jungle");
        biomesMap.put("south2","Desert Oasis");
        biomesMap.put("south3","Savanna Plains");
        biomesMap.put("east1","Mystic River");
        biomesMap.put("east2","Enchanted Forest");
        biomesMap.put("east3","Volcano");
        biomesMap.put("west1","Island Paradise");
        biomesMap.put("west2","Coral Reef");
        biomesMap.put("west3","Deep Ocean");
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
        if (PlayerPos.getX() <= 10 && PlayerPos.getY() >= 0 || PlayerPos.getY() <= 10) {
            return biomesMap.get("north1");
        } else if (PlayerPos.getX() == 0 && PlayerPos.getY() == 2) {
            return biomesMap.get("north2");
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == 3) {
            return biomesMap.get("north3");
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == -1) {
            return biomesMap.get("south1");
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == -2) {
            return biomesMap.get("south2");
        }else if (PlayerPos.getX() == 0 && PlayerPos.getY() == -3) {
            return biomesMap.get("south3");
        }else if (PlayerPos.getX() == 1 && PlayerPos.getY() == 0) {
            return biomesMap.get("east1");
        }else if (PlayerPos.getX() == 2 && PlayerPos.getY() == 0) {
            return biomesMap.get("east2");
        }else if (PlayerPos.getX() == 3 && PlayerPos.getY() == 0) {
            return biomesMap.get("east3");
        }else if (PlayerPos.getX() == -1 && PlayerPos.getY() == 0) {
            return biomesMap.get("west1");
        }else if (PlayerPos.getX() == -2 && PlayerPos.getY() == 0) {
            return biomesMap.get("west2");
        }else if (PlayerPos.getX() == -3 && PlayerPos.getY() == 0) {
            return biomesMap.get("west3");
        }else {
            return "error bitch!";
        }
    }
}
