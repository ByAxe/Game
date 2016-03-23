package org.byaxe.data.entities;

import org.byaxe.data.entities.creations.heroes.HeroesEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "skills")
public class SkillsEntity extends AbstractEntity {
    private String title;
    private String description;
    private int requiredLevel;
    private int requiredMp;
    private int level;
    private int hp;
    private int mp;
    private int strength;
    private int agility;
    private int intellect;
    private int criticalChance;
    private int damage;
    private int protection;
    private boolean isActive;
    private boolean isTargetEnemy;
    private boolean isAbsolute;
    private Set<EffectsEntity> effects = new HashSet<>();
    private Set<HeroesEntity> heroes = new HashSet<>();

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "required_level")
    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    @Column(name = "required_mp")
    public int getRequiredMp() {
        return requiredMp;
    }

    public void setRequiredMp(int requiredMp) {
        this.requiredMp = requiredMp;
    }

    @Column(name = "level")
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    @Column(name = "damage")
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Column(name = "protection")
    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Column(name = "is_target_enemy")
    public boolean isTargetEnemy() {
        return isTargetEnemy;
    }

    public void setTargetEnemy(boolean targetEnemy) {
        isTargetEnemy = targetEnemy;
    }

    @Column(name = "is_absolute")
    public boolean isAbsolute() {
        return isAbsolute;
    }

    public void setAbsolute(boolean absolute) {
        isAbsolute = absolute;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "skills_effects", joinColumns = {
            @JoinColumn(name = "skill_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "effect_id")
    })
    public Set<EffectsEntity> getEffects() {
        return effects;
    }

    public void setEffects(Set<EffectsEntity> effects) {
        this.effects = effects;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "skills")
    public Set<HeroesEntity> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<HeroesEntity> heroes) {
        this.heroes = heroes;
    }
}
