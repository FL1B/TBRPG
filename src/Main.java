import PlayerClass.MageFactory;
import PlayerClass.PlayerClass;
import PlayerClass.PlayerClassFactory;
import PlayerClass.WarriorFactory;

import java.util.Arrays;

public class Main
{

    public static void main(String[] args) {
                TextRPG game = new TextRPG();



        game.chooseCharacter();
        System.out.println(game.chooseCharacter().getPlayerClassName());
        game.firstMenu();
        game.movePlayer();
    }
}
