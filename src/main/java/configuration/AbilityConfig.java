package configuration;

import abilities.IAbility;
import abilities.implementLevel.constructive.NaturePower;
import abilities.implementLevel.constructive.PlainHeal;
import abilities.implementLevel.destructive.FireBall;
import abilities.implementLevel.destructive.FrostWave;
import data.SystemData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class AbilityConfig {
    @Bean
    public SystemData systemData() {
        SystemData sd = new SystemData();
        sd.fillMap();
        return sd;
    }

    @Bean
    public FireBall fireBall() {
        return new FireBall("Fire Ball",
                "Fire ball can cause a lot of damage to the enemy.",
                0, 20, (byte) 3, 20);
    }

    @Bean
    public FrostWave frostWave() {
        return new FrostWave("Frost Wave",
                "Frost wave is very dangerous magic. Use it only if it necessary.",
                0, 100, (byte) 8, 50);
    }

    @Bean
    public NaturePower naturePower() {
        return new NaturePower("Nature Power",
                "Take these power of the Nature and let it pass throughout your body.",
                60, 0, (byte) 5, 30);
    }

    @Bean
    public PlainHeal plainHeal() {
        return new PlainHeal("Plain Heal",
                "It's just a plain healing magic that everybody knows.",
                20, 0, (byte) 1, 10);
    }

    /*TODO transport Beans above in another Configuration file*/

    @Bean(name = "abilityMap")
    public HashMap<String, IAbility> abilityMap() {
        HashMap<String, IAbility> abilityMap = new HashMap<>();

        abilityMap.put(fireBall().getDescription(), fireBall());
        abilityMap.put(frostWave().getDescription(), frostWave());
        abilityMap.put(naturePower().getDescription(), naturePower());
        abilityMap.put(plainHeal().getDescription(), plainHeal());

        return abilityMap;
    }
}
