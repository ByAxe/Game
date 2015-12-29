package creations;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.EnumMap;
import java.util.Map;

public class Hero extends AbstractHero {

    public Hero(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int MP, int HP, int strength, int agility, Map<String, IAbility> abilities, int experience) {
        super(equipmentMap, name, level, MP, HP, strength, agility, abilities, experience);
    }

    public Hero() {

    }

    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public int resistance() {
        return super.resistance();
    }

    @Override
    public void drop(TypeOfEquipment typeOfEquipment) {
        this.equipmentMap.remove(typeOfEquipment);
    }

    @Override
    public String enter() {
        return "\nGo ahead!";
    }

    @Override
    public String escape() {
        return "\nLet's get out of here!";
    }

    @Override
    public void changeEquipment(TypeOfEquipment typeOfEquipment, IEquipment equipment) {
        this.equipmentMap.put(typeOfEquipment, equipment);
    }

    @Override
    public void useAbility(String title) {
        this.abilities.get(title);
    }

    @Override
    public void addAbility(String title, IAbility ability) {
        this.abilities.put(title, ability);
    }

}
