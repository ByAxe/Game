package equipment.abstractLevel;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;

public abstract class AbstractEquipment implements IEquipment {
    private IAbility ability;
    private TypeOfEquipment typeOfEquipment;
    private String title;
    private String description;
    private int requiredLevel;

    public AbstractEquipment(TypeOfEquipment typeOfEquipment, IAbility ability, String title, String description, int requiredLevel) {
        this.ability = ability;
        this.typeOfEquipment = typeOfEquipment;
        this.title = title;
        this.description = description;
        this.requiredLevel = requiredLevel;
    }

    public AbstractEquipment() {

    }

    public IAbility getAbility() {
        return ability;
    }

    public void setAbility(IAbility ability) {
        this.ability = ability;
    }

    public TypeOfEquipment getTypeOfEquipment() {
        return typeOfEquipment;
    }

    public void setTypeOfEquipment(TypeOfEquipment typeOfEquipment) {
        this.typeOfEquipment = typeOfEquipment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
