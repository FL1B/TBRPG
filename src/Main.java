import java.util.Arrays;

public class Main
{

    public static void main(String[] args) {
        TextRPG game = new TextRPG();
        game.firstMenu();
        game.movePlayer();
        System.out.println(Biomes.northBiome);
    }
}
