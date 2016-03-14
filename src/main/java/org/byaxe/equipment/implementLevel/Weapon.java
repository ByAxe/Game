package org.byaxe.equipment.implementLevel;

import org.byaxe.abilities.IAbility;
import org.byaxe.data.TypeOfEquipment;
import org.byaxe.equipment.abstractLevel.AbstractWeapon;

public class Weapon extends AbstractWeapon {

    public Weapon(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int damage) {
        super(typeOfEquipment, ability, title, description, requiredLevel, damage);
    }

    public Weapon() {
    }
}
