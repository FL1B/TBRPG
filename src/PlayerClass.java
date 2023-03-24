public class PlayerClass{


    private String PlayerClassName;
    private int healthPoints;
    private int mana;
    private int strength;
    private int intelligence;



    public String getPlayerClassName() {
        return PlayerClassName;
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public int getMana() {
        return mana;
    }
    public int getStrength() {
        return strength;
    }
    public int getIntelligence() {
        return intelligence;
    }



    public void setPlayerClassName(String playerClassName) {
        PlayerClassName = playerClassName;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}
