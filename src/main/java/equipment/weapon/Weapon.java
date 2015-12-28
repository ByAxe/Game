package equipment.weapon;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.AbstractWeapon;

public class Weapon extends AbstractWeapon {

    public Weapon(IAbility ability, TypeOfEquipment typeOfEquipment, String title, String description, int requiredLevel, int damage) {
        super(ability, typeOfEquipment, title, description, requiredLevel, damage);
    }

    public Weapon() {
    }
}
