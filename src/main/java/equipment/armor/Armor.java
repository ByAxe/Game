package equipment.armor;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.AbstractArmor;

public class Armor extends AbstractArmor{
    public Armor(IAbility ability, TypeOfEquipment typeOfEquipment, String title, String description, int requiredLevel, int protection) {
        super(ability, typeOfEquipment, title, description, requiredLevel, protection);
    }

    public Armor() {
    }
}
