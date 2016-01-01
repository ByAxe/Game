package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EquipmentConfig.class, HeroConfig.class, AspectConfig.class, MonsterConfig.class, AbilityConfig.class})
public class AppConfig {
}
