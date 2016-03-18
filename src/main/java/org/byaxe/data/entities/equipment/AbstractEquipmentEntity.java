package org.byaxe.data.entities.equipment;

import org.byaxe.data.entities.AbstractEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEquipmentEntity extends AbstractEntity {

    /*Might I will have here problems*/
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

}
