package PlayerClass;

public class RogueFactory extends PlayerClassFactory {
    @Override
    public PlayerClass createPlayerClass() {
        PlayerClass rogue = new PlayerClass();
        rogue.setPlayerClassName("Rogue");
        rogue.setHealthPoints(8);
        rogue.setMana(2);
        rogue.setStrength(2);
        rogue.setIntelligence(2);
        rogue.setImage("src/images/player/rogue_resting_12x16.png");
        return rogue;
    }
}
