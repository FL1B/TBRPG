import PlayerClass.MageFactory;
import PlayerClass.PlayerClass;
import PlayerClass.PlayerClassFactory;
import PlayerClass.WarriorFactory;

import java.util.Arrays;

public class Main
{

    public static void main(String[] args) {
                TextRPG game = new TextRPG();

        System.out.println(
                "Class "+game.chooseCharacter().getPlayerClassName() +"\n" +
                "HP " + game.currentClass.getHealthPoints() +"\n" +
                "Str " + game.currentClass.getStrength() +"\n" +
                "Mana " + game.currentClass.getMana() +"\n" +
                "Int " + game.currentClass.getIntelligence() +"\n"
        );
        game.firstMenu();
        game.movePlayer();
    }
}
