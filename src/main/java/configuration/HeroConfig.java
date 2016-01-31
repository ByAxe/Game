package configuration;

import creations.implementLevel.Hero;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.implementLevel.Armor;
import equipment.implementLevel.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import regular.expression.RegExp;

import java.util.EnumMap;
import java.util.HashMap;

import static data.SystemData.MIN_LEVEL;

@Configuration
public class HeroConfig {

    @Bean(name = "hero")
    @Autowired
    public Hero hero(Weapon weapon, Armor armor) {
        EnumMap<TypeOfEquipment, IEquipment> equipmentMap = new EnumMap<>(TypeOfEquipment.class);
        equipmentMap.put(TypeOfEquipment.WEAPON, weapon);
        equipmentMap.put(TypeOfEquipment.ARMOR, armor);
        return new Hero(equipmentMap, RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", RegExp.NAME),
                MIN_LEVEL, 20, 100, 15, 15, null, 0);
    }

    @Bean
    public HashMap<Byte, Integer> experienceTable() {
        HashMap<Byte, Integer> requiredExperience = new HashMap<>();
        for (byte i = 1; i <= 10; i++) {
            requiredExperience.put(i, i * 100);
        }
        return requiredExperience;
    }
}
