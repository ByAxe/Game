package creations;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;

public interface ICreation {
    int attack();

    int resistance();

    void drop(TypeOfEquipment typeOfEquipment);

    default String enter() {
        return null;
    }

    default String escape() {
        return null;
    }

    default void checkInventory() {
    }

    default void changeEquipment(TypeOfEquipment typeOfEquipment, IEquipment equipment) {
    }

    default void showAbilities() {
    }

    default void useAbility(String title) {
    }

    default void addAbility(String title, IAbility ability) {
    }


}
