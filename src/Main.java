import PlayerClass.MageFactory;
import PlayerClass.PlayerClass;
import PlayerClass.PlayerClassFactory;
import PlayerClass.WarriorFactory;

import java.util.Arrays;

public class Main
{

    public static void main(String[] args) {

        PlayerClassFactory warriorFactory = new WarriorFactory();
        PlayerClass warrior = warriorFactory.createPlayerClass();

        TextRPG game = new TextRPG();

        System.out.println(warrior.getPlayerClassName());

        game.firstMenu();
        game.movePlayer();
    }
}
