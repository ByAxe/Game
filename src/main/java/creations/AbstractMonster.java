package creations;

import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.Map;

public abstract class AbstractMonster extends AbstractCreation {
    private String description;

    public AbstractMonster(Map<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int MP, int HP, int strength, int agility, String description) {
        super(equipmentMap, name, level, MP, HP, strength, agility);
        this.description = description;
    }

    public AbstractMonster() {

    }
}
