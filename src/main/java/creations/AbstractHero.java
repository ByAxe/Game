package creations;

import abilities.IAbility;
import data.TypeOfEquipment;
import equipment.IEquipment;

import java.util.EnumMap;
import java.util.Map;

public abstract class AbstractHero extends AbstractCreation implements IHero {
    protected Map<String, IAbility> abilities;
    private int experience;

    public AbstractHero(String name, EnumMap<TypeOfEquipment, IEquipment> equipmentMap, byte level, int MP, int HP, int strength, int agility, Map<String, IAbility> abilities, int experience) {
        super(name, equipmentMap, level, MP, HP, strength, agility);
        this.abilities = abilities;
        this.experience = experience;
    }

    public AbstractHero() {

    }

    public Map<String, IAbility> getAbilities() {
        return abilities;
    }

    public void setAbilities(Map<String, IAbility> abilities) {
        this.abilities = abilities;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
