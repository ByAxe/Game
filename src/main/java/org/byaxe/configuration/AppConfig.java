package org.byaxe.configuration;

import org.byaxe.data.SystemData;
import org.byaxe.data.dao.interfaces.ILevelsDAO;
import org.byaxe.data.entities.creations.heroes.LevelsEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@Import({ HeroConfig.class, AspectConfig.class, DaoConfig.class, JpaConfig.class})
public class AppConfig {

    @Bean
    @DependsOn("experienceTable")
    public SystemData systemData() {
        return new SystemData();
    }


    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final ILevelsDAO levelsDAO = (ILevelsDAO) context.getBean("levels");

        levelsDAO.getLevelsList().stream()
                .map(LevelsEntity::getRequiredExperience)
                .forEach(System.out::println);
    }
}