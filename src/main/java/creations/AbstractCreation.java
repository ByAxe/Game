package creations;

import data.TypeOfEquipment;
import equipment.AbstractArmor;
import equipment.AbstractEquipment;
import equipment.AbstractWeapon;
import equipment.IEquipment;

import java.util.EnumMap;
import java.util.Map;

import static data.SystemData.*;

public abstract class AbstractCreation implements ICreation {

    /*TODO Maybe I should use here EmunMap instead of merely Map*/
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
        IEquipment weapon = this.equipmentMap.get(TypeOfEquipment.WEAPON);
        boolean isAbilityInWeapon = null != ((AbstractEquipment) weapon).getAbility();
        int damage = ((AbstractWeapon) weapon).getDamage();

        return (isAbilityInWeapon ? ((AbstractEquipment) weapon).getAbility().use() : 0)
                + damage * (int) (PERFORMANCE_FACTOR * this.getStrength()) + randomDistribution();

    }

    public int resistance() {
        IEquipment armor = this.equipmentMap.get(TypeOfEquipment.ARMOR);
        int protection = ((AbstractArmor) armor).getProtection();
        boolean isAbilityInArmor = null != ((AbstractEquipment) armor).getAbility();

        return (isAbilityInArmor ? ((AbstractEquipment) armor).getAbility().use() : 0)
                + protection * (int) (PERFORMANCE_FACTOR * this.getAgility()) + randomDistribution();
    }

    public int randomDistribution() {
        return MIN_RANDOM + (int) (Math.random() * ((MAX_RANDOM - MIN_RANDOM) + 1));
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