package org.byaxe.configuration;

import org.byaxe.data.dao.implementation.EquipmentDAOImpl;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.heroes.ParametersEntity;
import org.byaxe.data.entities.creations.heroes.PointsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfig {

    @Autowired
    EquipmentDAOImpl equipment;

/*
    @Bean(name = "hero")
    public HeroesEntity hero() {
        HeroesEntity hero = new HeroesEntity();

        hero.setName(RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", RegExp.NAME));
        hero.setArmor(equipment.getArmorById(1));
        hero.setWeapon(equipment.getWeaponById(1));
        hero.setPoints(setBasicPoint(hero));
        hero.setExperience(0);
        hero.setLvl(MIN_LEVEL);
        hero.setParameters(setBasicParameters(hero));
        */
/*TODO I finished here*//*

        return hero;
    }

*/
    private ParametersEntity setBasicParameters(final HeroesEntity hero) {
        return new ParametersEntity(100, 40, 10, 10, 10, hero);
    }

    private PointsEntity setBasicPoint(final HeroesEntity hero) {
        return new PointsEntity(10, 0, hero);
    }
}
