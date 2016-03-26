package org.byaxe.configuration;

import org.byaxe.Cycle;
import org.byaxe.data.SystemData;
import org.byaxe.data.dao.implementation.MonsterDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MonsterDAOImpl monsterDAO = (MonsterDAOImpl) context.getBean("monsterDAOImpl");

        monsterDAO.getMonstersList().stream().forEach(System.out::println);
    }

}