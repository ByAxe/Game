package org.byaxe.equipment;

import org.byaxe.abilities.IAbility;
import org.byaxe.data.TypeOfEquipment;

public interface IEquipment {
    IAbility getAbility();

    void setAbility(IAbility ability);

    TypeOfEquipment getTypeOfEquipment();

    void setTypeOfEquipment(TypeOfEquipment typeOfEquipment);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    int getRequiredLevel();

    void setRequiredLevel(int requiredLevel);

    default int getProtection(){
        return 0;
    }
    default int getDamage(){
        return 0;
    }
}
