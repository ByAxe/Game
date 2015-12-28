package creations;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;

public interface IHero {
    String enter();

    String escape();

    void changeEquipment(TypeOfEquipment typeOfEquipment, IEquipment equipment);

    void useAbility(String title);

    void addAbility(String title, IAbility ability);
}
