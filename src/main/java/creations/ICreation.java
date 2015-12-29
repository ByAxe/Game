package creations;

import data.TypeOfEquipment;

public interface ICreation {
    int attack();

    int resistance();

    void drop(TypeOfEquipment typeOfEquipment);
}
