package equipment.abstractLevel;

import abilities.IAbility;
import data.TypeOfEquipment;

public abstract class AbstractWeapon extends AbstractEquipment {
    private int damage;

    public AbstractWeapon(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel, int damage) {
        super(typeOfEquipment, ability, title, description, requiredLevel);
        this.damage = damage;
    }

    public AbstractWeapon() {

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
