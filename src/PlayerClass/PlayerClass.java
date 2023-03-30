package PlayerClass;

public class PlayerClass{


    private String playerClassName;
    private int healthPoints;
    private int mana;
    private int strength;
    private int intelligence;
    private String image;



    public String getPlayerClassName() {
        return playerClassName;
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
    public String getImage() { return image;}



    public void setPlayerClassName(String playerClassName) {
        this.playerClassName = playerClassName;
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
    public void setImage(String image) {
        this.image = image;
    }
}
