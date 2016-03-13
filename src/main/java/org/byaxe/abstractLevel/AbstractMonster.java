package org.byaxe.abstractLevel;

import org.byaxe.TypeOfEquipment;
import org.byaxe.equipment.IEquipment;

import java.util.EnumMap;

public abstract class AbstractMonster extends AbstractCreation {
    private String description;

    public AbstractMonster(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int maxMP, int maxHP, int strength, int agility, String description) {
        super(equipmentMap, name, level, maxMP, maxHP, strength, agility);
        this.description = description;
    }

    public AbstractMonster() {

    }
}
