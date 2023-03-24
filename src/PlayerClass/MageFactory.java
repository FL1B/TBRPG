package PlayerClass;

import PlayerClass.PlayerClass;

public class MageFactory extends PlayerClassFactory {
    @Override
    public PlayerClass createPlayerClass() {
        PlayerClass mage = new PlayerClass();
        mage.setPlayerClassName("Mage");
        mage.setHealthPoints(80);
        mage.setMana(100);
        mage.setStrength(5);
        mage.setIntelligence(30);
        return mage;
    }
}
