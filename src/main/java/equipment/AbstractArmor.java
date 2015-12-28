package equipment;

import abilities.IAbility;
import data.TypeOfEquipment;

public abstract class AbstractArmor extends AbstractEquipment {
    private int protection;

    public AbstractArmor(IAbility ability, TypeOfEquipment typeOfEquipment, String title, String description, int requiredLevel, int protection) {
        super(ability, typeOfEquipment, title, description, requiredLevel);
        this.protection = protection;
    }

    public AbstractArmor() {

    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }
}
