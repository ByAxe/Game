package org.byaxe.data.entities.equipment;

import org.byaxe.data.entities.AbstractEntity;
import org.byaxe.data.entities.equipment.armor.ArmorEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rarity")
public class RarityEntity extends AbstractEntity {
    private String rarity;
    private double dropChance;
    private String description;
    private List<WeaponEntity> weapon = new ArrayList<>();
    private List<ArmorEntity> armor = new ArrayList<>();

    @Column(name = "rarity")
    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    @Column(name = "drop_chance")
    public double getDropChance() {
        return dropChance;
    }

    public void setDropChance(double chance) {
        this.dropChance = chance;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany
    public List<WeaponEntity> getWeapon() {
        return weapon;
    }

    public void setWeapon(List<WeaponEntity> weapon) {
        this.weapon = weapon;
    }

    @OneToMany
    public List<ArmorEntity> getArmor() {
        return armor;
    }

    public void setArmor(List<ArmorEntity> armor) {
        this.armor = armor;
    }
}
