package PlayerClass;

public class RogueFactory extends PlayerClassFactory {
    @Override
    public PlayerClass createPlayerClass() {
        PlayerClass rogue = new PlayerClass();
        rogue.setPlayerClassName("Rogue");
        rogue.setHealthPoints(70);
        rogue.setMana(80);
        rogue.setStrength(20);
        rogue.setIntelligence(10);
        return rogue;
    }
}
