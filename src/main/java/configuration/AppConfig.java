package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SkillsAndEquipmentConfig.class, MonsterConfig.class})
@EnableAspectJAutoProxy
public class AppConfig {
}
