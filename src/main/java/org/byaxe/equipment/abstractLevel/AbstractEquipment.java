package org.byaxe.equipment.abstractLevel;

import org.byaxe.abilities.IAbility;
import org.byaxe.TypeOfEquipment;
import org.byaxe.equipment.IEquipment;

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

    @Override
    public IAbility getAbility() {
        return ability;
    }

    @Override
    public void setAbility(IAbility ability) {
        this.ability = ability;
    }

    @Override
    public TypeOfEquipment getTypeOfEquipment() {
        return typeOfEquipment;
    }

    @Override
    public void setTypeOfEquipment(TypeOfEquipment typeOfEquipment) {
        this.typeOfEquipment = typeOfEquipment;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getRequiredLevel() {
        return requiredLevel;
    }

    @Override
    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
