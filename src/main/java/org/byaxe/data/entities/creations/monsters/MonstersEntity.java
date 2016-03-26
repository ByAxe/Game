package org.byaxe.data.entities.creations.monsters;

import org.byaxe.data.entities.AbstractEntity;
import org.byaxe.data.entities.EffectsEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "monsters")
public class MonstersEntity extends AbstractEntity {

    private String name;
    private int lvl;
    private String description;
    private int damageMin;
    private int damageMax;
    private int protectionMin;
    private int protectionMax;
    private int experience;
    private int hp;
    private int currentHp;
    private Set<EffectsEntity> effects;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lvl")
    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "damage_min")
    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    @Column(name = "damage_max")
    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    @Column(name = "protection_min")
    public int getProtectionMin() {
        return protectionMin;
    }

    public void setProtectionMin(int protectionMin) {
        this.protectionMin = protectionMin;
    }

    @Column(name = "protection_max")
    public int getProtectionMax() {
        return protectionMax;
    }

    public void setProtectionMax(int protectionMax) {
        this.protectionMax = protectionMax;
    }

    @Column(name = "experience")
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "monsters_effects", joinColumns = {
            @JoinColumn(name = "monster_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "effect_id")
    })
    public Set<EffectsEntity> getEffects() {
        return effects;
    }

    public void setEffects(Set<EffectsEntity> effects) {
        this.effects = effects;
    }
}
