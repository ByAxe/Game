package org.byaxe.data.entities;

import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;
import org.byaxe.data.entities.equipment.armor.ArmorEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "effects")
public class EffectsEntity extends AbstractEntity {

    private String title;
    private int hp;
    private int mp;
    private int strength;
    private int agility;
    private int intellect;
    private double criticalChance;
    private Set<ArmorEntity> armorEffects = new HashSet<>();
    private Set<WeaponEntity> weaponEffects = new HashSet<>();
    private Set<HeroesEntity> heroesEffects = new HashSet<>();
    private Set<MonstersEntity> monstersEffects = new HashSet<>();
    private Set<SkillsEntity> skillsEffects = new HashSet<>();

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "hp")
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Column(name = "mp")
    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    @Column(name = "strength")
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Column(name = "agility")
    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    @Column(name = "intellect")
    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    @Column(name = "critical_chance")
    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "effects")
    public Set<ArmorEntity> getArmorEffects() {
        return armorEffects;
    }

    public void setArmorEffects(Set<ArmorEntity> armorEffects) {
        this.armorEffects = armorEffects;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "effects")
    public Set<WeaponEntity> getWeaponEffects() {
        return weaponEffects;
    }

    public void setWeaponEffects(Set<WeaponEntity> weaponEffects) {
        this.weaponEffects = weaponEffects;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "effects")
    public Set<HeroesEntity> getHeroesEffects() {
        return heroesEffects;
    }

    public void setHeroesEffects(Set<HeroesEntity> heroesEffects) {
        this.heroesEffects = heroesEffects;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "effects")
    public Set<MonstersEntity> getMonstersEffects() {
        return monstersEffects;
    }

    public void setMonstersEffects(Set<MonstersEntity> monstersEffects) {
        this.monstersEffects = monstersEffects;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "effects")
    public Set<SkillsEntity> getSkillsEffects() {
        return skillsEffects;
    }

    public void setSkillsEffects(Set<SkillsEntity> skillsEffects) {
        this.skillsEffects = skillsEffects;
    }
}
