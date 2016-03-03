package creations.implementLevel;

import abilities.IAbility;
import creations.abstractLevel.AbstractHero;
import data.TypeOfEquipment;
import equipment.IEquipment;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class Hero extends AbstractHero {

    public Hero(EnumMap<TypeOfEquipment, IEquipment> equipmentMap, String name, byte level, int maxMP, int maxHP, int strength, int agility, Map<String, IAbility> abilities, int experience) {
        super(equipmentMap, name, level, maxMP, maxHP, strength, agility, abilities, experience);
    }

    public Hero() {

    }

    @Override
    public int attack() {
        return super.attack();
    }

    @Override
    public int resistance() {
        return super.resistance();
    }

    @Override
    public void drop(TypeOfEquipment typeOfEquipment) {
        this.equipmentMap.remove(typeOfEquipment);
    }

    @Override
    public String enter() {
        return "";
    }

    @Override
    public void startBattle() {

    }

    @Override
    public void checkInventory() {

    }

    @Override
    public void showAbilities() {

    }

    @Override
    public void changeEquipment(final TypeOfEquipment typeOfEquipment, final IEquipment equipment) {
        this.equipmentMap.put(typeOfEquipment, equipment);
    }

    @Override
    public void useAbility(final String title) {
        this.abilities.get(title);
    }

    @Override
    public void addAbility(final String title, final IAbility ability) {
        this.abilities.put(title, ability);
    }

}
