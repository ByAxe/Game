package configuration;

import creations.Hero;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.armor.Armor;
import equipment.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import regular.expression.RegExp;

import java.util.EnumMap;

@Configuration
public class HeroConfig {

    @Bean(name = "hero")
    @Autowired
    public Hero hero(Weapon weapon, Armor armor) {
        EnumMap<TypeOfEquipment, IEquipment> equipmentMap = new EnumMap<>(TypeOfEquipment.class);
        equipmentMap.put(TypeOfEquipment.WEAPON, weapon);
        equipmentMap.put(TypeOfEquipment.ARMOR, armor);
        return new Hero(equipmentMap, RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", RegExp.NAME),
                (byte) 1, 20, 100, 15, 15, null, 0);
    }
}
