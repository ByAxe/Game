package org.byaxe.configuration;

import org.byaxe.logic.implementation.HeroBusinessLogicImpl;
import org.byaxe.logic.implementation.MonsterBusinessLogicImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by byaxe on 26.03.16.
 */
@Configuration
public class LogicConfig {

    @Bean(name = "heroBusinessLogic")
    @DependsOn({"effectsDAOImpl, skillsDAOImpl"})
    public HeroBusinessLogicImpl heroBusinessLogic() {
        return new HeroBusinessLogicImpl();
    }

    @Bean(name = "monsterBusinessLogic")
    @DependsOn("monsterDAOImpl")
    public MonsterBusinessLogicImpl monsterBusinessLogic() {
        return new MonsterBusinessLogicImpl();
    }
}
