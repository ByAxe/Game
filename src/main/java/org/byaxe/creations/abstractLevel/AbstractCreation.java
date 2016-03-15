package org.byaxe.creations.abstractLevel;

import org.byaxe.creations.ICreation;
import org.byaxe.data.TypeOfEquipment;
import org.byaxe.equipment.IEquipment;

import java.util.EnumMap;
import java.util.Map;

import static org.byaxe.data.SystemData.PERFORMANCE_FACTOR;
import static org.byaxe.data.SystemData.randomDistribution;
import static org.byaxe.data.TypeOfEquipment.ARMOR;
import static org.byaxe.data.TypeOfEquipment.WEAPON;

public abstract class AbstractCreation implements ICreation {

    protected EnumMap<TypeOfEquipment, IEquipment> equipmentMap;
    private String name;
    private byte level;
    private int maxMP;
    private int currentMP;
    private int currentHP;
    private int maxHP;
    private int strength;
    private int agility;

    public AbstractCreation(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int maxMP, int maxHP, int strength, int agility) {
        this.equipmentMap = equipmentMap;
        this.name = name;
        this.level = level;
        this.maxMP = maxMP;
        this.currentMP = maxMP;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.strength = strength;
        this.agility = agility;
    }

    public AbstractCreation() {
    }

    @Override
    public int attack() {
        IEquipment weapon = this.equipmentMap.get(WEAPON);
        boolean isAbilityInWeapon = null != weapon.getAbility();
        int damage = weapon.getDamage();

        return (isAbilityInWeapon ? weapon.getAbility().use() : 0)
                + damage * (int) (PERFORMANCE_FACTOR * this.getStrength()) + randomDistribution();

    }

    @Override
    public int resistance() {
        IEquipment armor = this.equipmentMap.get(ARMOR);
        int protection = armor.getProtection();
        boolean isAbilityInArmor = null != armor.getAbility();

        return (isAbilityInArmor ? armor.getAbility().use() : 0)
                + protection * (int) (PERFORMANCE_FACTOR * this.getAgility()) + randomDistribution();
    }

    public Map<TypeOfEquipment, IEquipment> getEquipmentMap() {
        return equipmentMap;
    }

    public void setEquipmentMap(EnumMap<TypeOfEquipment, IEquipment> equipmentMap) {
        this.equipmentMap = equipmentMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}