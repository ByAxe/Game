package creations;

import data.TypeOfEquipment;

public interface ICreation {
    int attack();

    void drop(TypeOfEquipment typeOfEquipment);
}
