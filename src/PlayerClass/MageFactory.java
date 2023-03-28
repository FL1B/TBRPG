package PlayerClass;

import PlayerClass.PlayerClass;

public class MageFactory extends PlayerClassFactory {
    @Override
    public PlayerClass createPlayerClass() {
        PlayerClass mage = new PlayerClass();
        mage.setPlayerClassName("Mage");
        mage.setHealthPoints(6);
        mage.setMana(4);
        mage.setStrength(0);
        mage.setIntelligence(1);
        return mage;
    }
}
