package configuration;

import regular.expression.RegExp;
import creations.Hero;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.armor.Armor;
import equipment.weapon.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;

@Configuration
public class HeroConfig {

    @Bean
    @Autowired
    public Hero hero(Weapon weapon, Armor armor) {
        EnumMap<TypeOfEquipment, IEquipment> equipmentMap = new EnumMap<>(TypeOfEquipment.class);
        equipmentMap.put(TypeOfEquipment.ARMOR, weapon);
        equipmentMap.put(TypeOfEquipment.WEAPON, armor);
        return new Hero(RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", RegExp.NAME),
                equipmentMap, (byte) 1, 20, 100, 15, 15, null, 0);
    }
}
