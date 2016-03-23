package org.byaxe.data.entities.creations.heroes;

import org.byaxe.data.entities.AbstractEntity;
import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.SkillsEntity;
import org.byaxe.data.entities.equipment.armor.ArmorEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "heroes")
public class HeroesEntity extends AbstractEntity {

    private String name;
    private String description;
    private int lvl;
    private int experience;
    private WeaponEntity weapon;
    private ArmorEntity armor;
    private ParametersEntity parameters;
    private PointsEntity points;
    private Set<EffectsEntity> effects = new HashSet<>();
    private Set<SkillsEntity> skills = new HashSet<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    @Column(name = "experience")
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "hero")
    public ArmorEntity getArmor() {
        return armor;
    }

    public void setArmor(ArmorEntity armor) {
        this.armor = armor;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "hero")
    public WeaponEntity getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponEntity weapon) {
        this.weapon = weapon;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "hero")
    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "hero")
    public PointsEntity getPoints() {
        return points;
    }

    public void setPoints(PointsEntity points) {
        this.points = points;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "heroes_effects", joinColumns = {
            @JoinColumn(name = "hero_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "effect_id")
    })
    public Set<EffectsEntity> getEffects() {
        return effects;
    }

    public void setEffects(Set<EffectsEntity> effects) {
        this.effects = effects;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "heroes_skills", joinColumns = {
            @JoinColumn(name = "hero_id", nullable = false)
    }, inverseJoinColumns = {
            @JoinColumn(name = "skill_id")
    })
    public Set<SkillsEntity> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillsEntity> skills) {
        this.skills = skills;
    }
}
