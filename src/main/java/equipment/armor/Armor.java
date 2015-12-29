package equipment.armor;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.AbstractArmor;

public class Armor extends AbstractArmor {
    public Armor(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int protection) {
        super(typeOfEquipment, ability, title, description, requiredLevel, protection);
    }

    public Armor() {
    }
}
