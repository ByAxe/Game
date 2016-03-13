package org.byaxe.equipment.abstractLevel;

import org.byaxe.abilities.IAbility;
import org.byaxe.TypeOfEquipment;

public abstract class AbstractWeapon extends AbstractEquipment {
    private int damage;

    public AbstractWeapon(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int damage) {
        super(typeOfEquipment, ability, title, description, requiredLevel);
        this.damage = damage;
    }

    public AbstractWeapon() {

    }

    @Override
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
