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

    default boolean escape() {
        return true;
    }

    default void checkInventory() {
    }

    default void changeEquipment(TypeOfEquipment typeOfEquipment, IEquipment equipment) {
    }

    default void showAbilities() {
    }

    default void useAbility(final String title) {
    }

    default void addAbility(final String title, final IAbility ability) {
    }

    default void startBattle() {
    }


}
