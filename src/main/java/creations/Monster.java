package creations;

import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.EnumMap;

public class Monster extends AbstractMonster {

    public Monster(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int MP, int HP, int strength, int agility, String description) {
        super(equipmentMap, name, level, MP, HP, strength, agility, description);
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
