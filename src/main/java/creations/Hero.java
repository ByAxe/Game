package creations;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.AbstractArmor;
import equipment.AbstractEquipment;
import equipment.AbstractWeapon;
import equipment.IEquipment;

import java.util.Map;

import static data.SystemData.*;

public class Hero extends AbstractHero {

    private IEquipment weapon = this.equipmentMap.get(TypeOfEquipment.WEAPON);
    private IEquipment armor = this.equipmentMap.get(TypeOfEquipment.ARMOR);

    /*TODO Here is, maybe I can have a problem in that case if these variables will be immutable while working with Hero() class*/

    public Hero(Map<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int MP, int HP, int strength, int agility, Map<String, IAbility> abilities, int experience) {
        super(equipmentMap, name, level, MP, HP, strength, agility, abilities, experience);
    }

    public Hero() {

    }

    @Override
    public int attack() {
        int rand = MIN_RANDOM + (int) (Math.random() * ((MAX_RANDOM - MIN_RANDOM) + 1));

        int damage = ((AbstractWeapon) weapon).getDamage();

        boolean isAbilityInWeapon = null != ((AbstractEquipment) weapon).getAbility();

        boolean isAbilityInArmor = null != ((AbstractEquipment) armor).getAbility();

        return (isAbilityInWeapon ?
                /*TODO add here functionality with abilities in Weapon*/
                ) +
                damage * (PERFORMANCE_FACTOR * this.getStrength())  + rand;
    }

    @Override
    public void drop(TypeOfEquipment typeOfEquipment) {
        this.equipmentMap.remove(typeOfEquipment);
    }

    @Override
    public String enter() {
        return "\nGo ahead!";
    }

    @Override
    public String escape() {
        return "\nLet's get out of here!";
    }

    @Override
    public void changeEquipment(TypeOfEquipment typeOfEquipment, IEquipment equipment) {
        this.equipmentMap.put(typeOfEquipment, equipment);
    }

    @Override
    public void useAbility(String title) {
        this.abilities.get(title);
    }

    @Override
    public void addAbility(String title, IAbility ability) {
        this.abilities.put(title, ability);
    }

}
