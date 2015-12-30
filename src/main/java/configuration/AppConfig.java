package configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EquipmentConfig.class, SkillsConfig.class, MonsterConfig.class, MyParserConfig.class})
@EnableAspectJAutoProxy
public class AppConfig {
}
