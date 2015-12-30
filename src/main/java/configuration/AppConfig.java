package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SkillsAndEquipmentConfig.class, HeroConfig.class, AspectConfig.class})
public class AppConfig {
}
