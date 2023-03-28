package Player;

import PlayerClass.PlayerClass;
public class Character extends PlayerClass {

    private String name;
    private int lvl;
    private int xp;
    private int maxHealth;
    private int currentHp;
    private int maxMana;
    private int currentMana;
    private int intelligence;
    private int strength;


    public Character(String name, int lvl, int xp, int maxHealth, int maxMana, int intelligence, int strength) {
        this.name = name;
        this.lvl = lvl;
        this.xp = xp;
        this.maxHealth = maxHealth;
        this.currentHp = maxHealth;
        this.maxMana = maxMana;
        this.currentMana = maxMana;
        this.intelligence = intelligence;
        this.strength = strength;


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }



    public int getStrength() {
        return strength;
    }
    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public int getCurrentMana() {
        return this.currentMana;
    }

    public int getIntelligence() {
        return this.intelligence;
    }
}
