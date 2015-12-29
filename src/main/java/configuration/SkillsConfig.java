package configuration;

import abilities.skills.constructive.NaturePower;
import abilities.skills.constructive.PlainHeal;
import abilities.skills.destructive.FireBall;
import abilities.skills.destructive.FrostWave;
import data.SystemData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SkillsConfig {

    @Bean
    public SystemData systemData(){
        return new SystemData();
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
}
