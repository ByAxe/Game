package org.byaxe.data.entities.creations.heroes;

import org.byaxe.data.entities.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
public class ParametersEntity extends AbstractEntity {

    private int hp;
    private int currentHp;
    private int mp;
    private int currentMp;
    private int strength;
    private int currentStrength;
    private int agility;
    private int currentAgility;
    private int intellect;
    private int currentIntellect;
    private HeroesEntity hero;

    @Column(name = "hp")
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Column(name = "current_hp")
    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    @Column(name = "mp")
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    @Column(name = "current_mp")
    public int getCurrentMp() {
        return currentMp;
    }

    public void setCurrentMp(int currentMp) {
        this.currentMp = currentMp;
    }

    @Column(name = "strength")
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Column(name = "current_strength")
    public int getCurrentStrength() {
        return currentStrength;
    }

    public void setCurrentStrength(int currentStrength) {
        this.currentStrength = currentStrength;
    }

    @Column(name = "agility")
    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Column(name = "current_agility")
    public int getCurrentAgility() {
        return currentAgility;
    }

    public void setCurrentAgility(int currentAgility) {
        this.currentAgility = currentAgility;
    }

    @Column(name = "intellect")
    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    @Column(name = "current_intellect")
    public int getCurrentIntellect() {
        return currentIntellect;
    }

    public void setCurrentIntellect(int currentIntellect) {
        this.currentIntellect = currentIntellect;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public HeroesEntity getHero() {
        return hero;
    }

    public void setHero(HeroesEntity hero) {
        this.hero = hero;
    }
}