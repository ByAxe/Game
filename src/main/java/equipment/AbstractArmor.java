package equipment;

import abilities.IAbility;
import data.TypeOfEquipment;

public abstract class AbstractArmor extends AbstractEquipment {
    private int protection;

    public AbstractArmor(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int protection) {
        super(typeOfEquipment, ability, title, description, requiredLevel);
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
