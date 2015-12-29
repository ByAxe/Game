package equipment.weapon;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.AbstractWeapon;

public class Weapon extends AbstractWeapon {

    public Weapon(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int damage) {
        super(typeOfEquipment, ability, title, description, requiredLevel, damage);
    }

    public Weapon() {
    }
}
