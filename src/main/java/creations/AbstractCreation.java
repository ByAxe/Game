package creations;

import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.Map;

public abstract class AbstractCreation implements ICreation {
    protected Map<TypeOfEquipment, IEquipment> equipmentMap;
    private String name;
    private byte level;
    private int MP;
    private int HP;
    private int strength;
    private int agility;

    public AbstractCreation(Map<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int MP, int HP, int strength, int agility) {
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

    public Map<TypeOfEquipment, IEquipment> getEquipmentMap() {
        return equipmentMap;
    }

    public void setEquipmentMap(Map<TypeOfEquipment, IEquipment> equipmentMap) {
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
