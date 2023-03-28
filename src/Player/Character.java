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
        this.setXp(xp);
        this.setLvl(lvl);
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
        if (this.getXp() >= 10000) {
            this.lvl = 100;
        } else if (this.getXp() >= 0){
            this.lvl = getXp() / 100;
        } else {
            this.lvl = 1;
        }
    }

    public void setXp(int xp) {
        this.xp += xp;
    }

    public void setMaxHealth(int maxHealth) {

        if (!(this.maxHealth >= 100)) {
            this.maxHealth = (int) Math.round(maxHealth * (getLvl() * 0.100505));
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
        if (!(this.maxMana >= 100)) {
            this.maxMana = (int) Math.round(maxMana * (getLvl() * 0.2512626));
            if (this.maxMana >= 100) {
                this.maxMana = 100;
            }
        } else {
            this.maxMana = 100;
        }
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setIntelligence(int intelligence) {
        if (!(this.intelligence >= 100)) {
            this.intelligence = (int) Math.round(intelligence * (getLvl() * 0.2512626));
            if (this.intelligence >= 100) {
                this.intelligence = 100;
            }
        } else {
            this.intelligence = 100;
        }
    }

    public void setStrength(int strength) {
        if (!(this.strength >= 100)) {
            this.strength = (int) Math.round(strength * (getLvl() * 0.2512626));
            if (this.strength >= 100) {
                this.strength = 100;
            }
        } else {
            this.strength = 100;
        }
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
