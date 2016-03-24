package org.byaxe.data;

import org.byaxe.creations.implementLevel.Hero;
import org.byaxe.equipment.IEquipment;

import static org.byaxe.data.TypeOfEquipment.ARMOR;
import static org.byaxe.data.TypeOfEquipment.WEAPON;
import static org.byaxe.regular.expression.RegExp.WEAPON;

public class InventoryInformation {

    public static String additionalInformationAboutWeapon(Hero hero) {
        IEquipment weapon = hero.getEquipmentMap().get(WEAPON);

        return "-----------------------------------WEAPON------------------------------------------\n" +
                weapon.getTitle() + " " +
                weapon.getDamage() + "\n" +
                "Abilities: " +
                (null == weapon.getAbility() ?
                        "nothing" :
                        weapon.getAbility())
                + "\n" +
                "Required level: " + weapon.getRequiredLevel() + "\n" +
                "Description: " + weapon.getDescription() +
                "\n-----------------------------------------------------------------------------------\n";
    }

    public static String additionalInformationAboutArmor(Hero hero) {
        IEquipment armor = hero.getEquipmentMap().get(ARMOR);

        return "\n-----------------------------------ARMOR------------------------------------------\n" +
                armor.getTitle() + " " +
                armor.getProtection() + "\n" +
                "Abilities: " +
                (null == armor.getAbility() ?
                        "nothing" :
                        armor.getAbility())
                + "\n" +
                "Required level: " + armor.getRequiredLevel() + "\n" +
                "Description: " + armor.getDescription() +
                "\n-----------------------------------------------------------------------------------\n";
    }
}
