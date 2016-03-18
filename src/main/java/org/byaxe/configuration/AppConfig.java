package org.byaxe.configuration;

import org.byaxe.data.SystemData;
import org.byaxe.data.entities.creations.heroes.LevelsEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Configuration
@Import({EquipmentConfig.class, HeroConfig.class, AspectConfig.class,
        MonsterConfig.class, AbilityConfig.class})
@ImportResource("classpath*:hibernate-config.xml")
public class AppConfig {

    @Bean
    @DependsOn("experienceTable")
    public SystemData systemData() {
        return new SystemData();
    }


    @PersistenceContext(unitName = "GAME_PERSISTENCE_UNIT")
    private EntityManager entityManager;

    @Transactional
    private List<LevelsEntity> getLevels() {
        return entityManager.createQuery("SELECT l from LevelsEntity l",
                LevelsEntity.class).getResultList();
    }

    public static void main(String[] args) {
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = context.getBean(AppConfig.class);

        List<LevelsEntity> resultSet = appConfig.getLevels();
        resultSet.stream().map(LevelsEntity::getRequiredExperience).forEach(System.out::println);
    }
}