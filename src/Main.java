import java.util.Arrays;

public class Main
{

    public static void main(String[] args) {
        TextRPG game = new TextRPG();
        System.out.println(Biomes.eastBiome);
        game.firstMenu();
        game.movePlayer();
    }
}
