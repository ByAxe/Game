package configuration;

import creations.Monster;
import data.TypeOfEquipment;
import equipment.IEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parser.MyParser;

import java.util.EnumMap;

@Configuration
public class MonsterConfig {

    /* TODO autowire here weapon and armor
    @Bean
    public Monster thief(IEquipment weapon, IEquipment armor) {
        EnumMap<TypeOfEquipment, IEquipment> equipmentMap = new EnumMap<>(TypeOfEquipment.class)
        equipmentMap.put(TypeOfEquipment.ARMOR,weapon);
        equipmentMap.put(TypeOfEquipment.WEAPON, armor);
        return new Monster("Weak Thief", equipmentMap, (byte) 1, 0, 50, 10, 10, "Old and weak thief");
    }*/
}
