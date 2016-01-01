package creations.implementLevel;

import creations.abstractLevel.AbstractMonster;
import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.EnumMap;

public class Monster extends AbstractMonster {

    public Monster(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int maxMP, int maxHP, int strength, int agility, String description) {
        super(equipmentMap, name, level, maxMP, maxHP, strength, agility, description);
    }

    public Monster() {

    }

    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public int resistance(){
        return super.resistance();
    }

    @Override
    public void drop(TypeOfEquipment typeOfEquipment) {
        this.equipmentMap.remove(typeOfEquipment);
    }
}
