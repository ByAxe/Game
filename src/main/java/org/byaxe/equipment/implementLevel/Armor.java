package org.byaxe.equipment.implementLevel;

import org.byaxe.abilities.IAbility;
import org.byaxe.data.TypeOfEquipment;
import org.byaxe.equipment.abstractLevel.AbstractArmor;

public class Armor extends AbstractArmor {
    public Armor(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int protection) {
        super(typeOfEquipment, ability, title, description, requiredLevel, protection);
    }

    public Armor() {
    }
}
