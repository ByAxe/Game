package org.byaxe.configuration;

import org.byaxe.data.dao.implementation.EquipmentDAOImpl;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.heroes.ParametersEntity;
import org.byaxe.data.entities.creations.heroes.PointsEntity;
import org.byaxe.data.entities.equipment.armor.ArmorEntity;
import org.byaxe.data.entities.equipment.weapon.WeaponEntity;
import org.byaxe.regular.expression.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.byaxe.data.SystemData.MIN_LEVEL;

@Configuration
public class HeroConfig {

    @Autowired
    EquipmentDAOImpl equipment;

    @Bean(name = "hero")
    public HeroesEntity hero() {
        HeroesEntity hero = new HeroesEntity();

        hero.setName(RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", RegExp.NAME));
        hero.setArmor((ArmorEntity) equipment.getEquipmentById(1, ArmorEntity.class));
        hero.setWeapon((WeaponEntity) equipment.getEquipmentById(1, WeaponEntity.class));
        hero.setPoints(setBasicPoint(hero));
        hero.setExperience(0);
        hero.setLvl(MIN_LEVEL);
        hero.setParameters(setBasicParameters(hero));
        /*TODO I finished here*/
        return hero;
    }

    private ParametersEntity setBasicParameters(final HeroesEntity hero) {
        return new ParametersEntity(100, 40, 10, 10, 10, hero);
    }

    private PointsEntity setBasicPoint(final HeroesEntity hero) {
        return new PointsEntity(10, 0, hero);
    }
}
