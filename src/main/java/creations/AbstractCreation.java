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
    private int MP;
    private int HP;
    private int strength;
    private int agility;

    /*TODO Here is, maybe I can have a problem in that case if these variables will be immutable while working with Hero() class*/
    private IEquipment armor = this.equipmentMap.get(TypeOfEquipment.ARMOR);
    private IEquipment weapon = this.equipmentMap.get(TypeOfEquipment.WEAPON);
    private boolean isAbilityInWeapon = null != ((AbstractEquipment) weapon).getAbility();
    private boolean isAbilityInArmor = null != ((AbstractEquipment) armor).getAbility();

    public AbstractCreation(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int MP, int HP, int strength, int agility) {
        this.equipmentMap = equipmentMap;
        this.name = name;
        this.level = level;
        this.MP = MP;
        this.HP = HP;
        this.strength = strength;
        this.agility = agility;
    }

    public AbstractCreation() {
    }

    /*TODO MAYBE IT WON'T WORK AS IT HAS TO! IF NO - I SHOULD TRANSPORT THIS METHOD INTO HERO() AND MONSTER() CLASSES*/
    @Override
    public int attack() {
        int damage = ((AbstractWeapon) weapon).getDamage();

        return (isAbilityInWeapon ? ((AbstractEquipment) weapon).getAbility().use() : 0)
                + damage * (int) (PERFORMANCE_FACTOR * this.getStrength()) + randomDistribution();
    }

    public int resistance() {
        int protection = ((AbstractArmor) armor).getProtection();

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

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
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
}