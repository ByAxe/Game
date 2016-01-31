package configuration;

import data.SystemData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EquipmentConfig.class, HeroConfig.class, AspectConfig.class, MonsterConfig.class, AbilityConfig.class})
public class AppConfig {

    @Bean
    @DependsOn("experienceTable")
    public SystemData systemData(){
        return new SystemData();
    }
}
