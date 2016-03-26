package org.byaxe.data.entities.equipment.armor;

import org.byaxe.data.entities.AbstractEntity;
import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.equipment.RarityEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "armor")
public class ArmorEntity extends AbstractEntity {

    private int protectionMin;
    private int protectionMax;
    private ArmorTypeEntity armorType;
    private Set<EffectsEntity> effects = new HashSet<>();

    private String title;
    private String description;
    private int requiredLevel;
    private int requiredStrength;
    private int requiredAgility;
    private int requiredIntellect;
    private RarityEntity rarity;
    private HeroesEntity hero;

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

    public void setRequiredLevel(int required_level) {
        this.requiredLevel = required_level;
    }

    @Column(name = "required_strength")
    public int getRequiredStrength() {
        return requiredStrength;
    }

    public void setRequiredStrength(int requiredStrength) {
        this.requiredStrength = requiredStrength;
    }

    @Column(name = "required_agility")
    public int getRequiredAgility() {
        return requiredAgility;
    }

    public void setRequiredAgility(int requiredAgility) {
        this.requiredAgility = requiredAgility;
    }

    @Column(name = "required_intellect")
    public int getRequiredIntellect() {
        return requiredIntellect;
    }

    public void setRequiredIntellect(int requiredIntellect) {
        this.requiredIntellect = requiredIntellect;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rarity")
    public RarityEntity getRarity() {
        return rarity;
    }

    public void setRarity(RarityEntity rarity) {
        this.rarity = rarity;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public HeroesEntity getHero() {
        return hero;
    }

    public void setHero(HeroesEntity hero) {
        this.hero = hero;
    }


    @Column(name = "protection_min")
    public int getProtectionMin() {
        return protectionMin;
    }

    public void setProtectionMin(int protection_min) {
        this.protectionMin = protection_min;
    }

    @Column(name = "protection_max")
    public int getProtectionMax() {
        return protectionMax;
    }

    public void setProtectionMax(int protection_max) {
        this.protectionMax = protection_max;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "armor_type")
    public ArmorTypeEntity getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorTypeEntity armorType) {
        this.armorType = armorType;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "armor_effects", joinColumns = {
            @JoinColumn(name = "armor_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "effect_id")
    })
    public Set<EffectsEntity> getEffects() {
        return effects;
    }

    public void setEffects(Set<EffectsEntity> effects) {
        this.effects = effects;
    }

    @Override
    public String toString() {
        return super.toString() + "Armor{" +
                "protectionMin=" + protectionMin +
                ", protectionMax=" + protectionMax +
                ", armorType=" + armorType +
                ", effects=" + effects +
                '}';
    }
}