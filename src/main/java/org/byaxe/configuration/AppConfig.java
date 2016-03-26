package org.byaxe.configuration;

import org.byaxe.Cycle;
import org.byaxe.data.SystemData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ HeroConfig.class, AspectConfig.class, DaoConfig.class, JpaConfig.class, LogicConfig.class})
public class AppConfig {

    @Bean
    public SystemData systemData() {
        return new SystemData();
    }

    @Bean
    public Cycle cycle(){
        return new Cycle();
    }

}