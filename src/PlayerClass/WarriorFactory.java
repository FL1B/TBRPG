package PlayerClass;

import PlayerClass.PlayerClass;

public class WarriorFactory extends PlayerClassFactory {
    @Override
    public PlayerClass createPlayerClass() {
        PlayerClass warrior = new PlayerClass();
        warrior.setPlayerClassName("Warrior");
        warrior.setHealthPoints(100);
        warrior.setMana(0);
        warrior.setStrength(20);
        warrior.setIntelligence(10);
        return warrior;

    }
}
