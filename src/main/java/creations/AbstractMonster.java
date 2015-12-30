package creations;

import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractMonster extends AbstractCreation {
    private String description;

    public AbstractMonster(String name, EnumMap<TypeOfEquipment, IEquipment> equipmentMap, byte level, int MP, int HP, int strength, int agility, String description) {
        super(name, equipmentMap, level, MP, HP, strength, agility);
        this.description = description;
    }

    public AbstractMonster() {

    }
}
