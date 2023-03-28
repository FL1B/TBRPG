package Player;

import PlayerClass.PlayerClass;

import java.util.Scanner;

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
        this.setName(name);
        this.setLvl(lvl);
        this.setXp(xp);
        this.setMaxHealth(maxHealth);
        this.setCurrentHp(getMaxHealth());
        this.setMaxMana(maxMana);
        this.setCurrentMana(getMaxMana());
        this.setIntelligence(intelligence);
        this.setStrength(strength);
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

        if (!(this.maxHealth >= 100)) {
            this.maxHealth = maxHealth + getLvl();
            if (this.maxHealth >= 100) {
                this.maxHealth = 100;
            }
        } else {
            this.maxHealth = 100;
        }
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana * getLvl();
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence * getLvl();
    }

    public void setStrength(int strength) {
        this.strength = strength * getLvl();
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
