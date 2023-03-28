package PlayerClass;

import PlayerClass.PlayerClass;

public class WarriorFactory extends PlayerClassFactory {
    @Override
    public PlayerClass createPlayerClass() {
        PlayerClass warrior = new PlayerClass();
        warrior.setPlayerClassName("Warrior");
        warrior.setHealthPoints(10);
        warrior.setMana(0);
        warrior.setStrength(4);
        warrior.setIntelligence(1);
        return warrior;

    }
}
