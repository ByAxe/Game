package org.byaxe.logic.implementation;

import org.byaxe.data.dao.interfaces.IMonsterDAO;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;
import org.byaxe.logic.interfaces.IMonsterBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;
import static org.byaxe.data.SystemData.*;

/**
 * Created by byaxe on 26.03.16.
 */
public class MonsterBusinessLogicImpl implements IMonsterBusinessLogic {

    @Autowired
    IMonsterDAO monsterDAO;

    @Override
    public MonstersEntity getMonsterDependsOnHero(final HeroesEntity hero) {
        final List<MonstersEntity> suitableMonsters = monsterDAO.getMonstersList().stream()
                .filter(m -> m.getLvl() == chooseLevelOfEnemy(hero.getLvl()))
                .collect(toList());

        return suitableMonsters.get(randomDistribution(suitableMonsters.size()));
    }

    private int randomDistribution(final int MAX) {
        final int MIN = 0;
        return ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
    }

    private int chooseLevelOfEnemy(final int heroLevel) {
        int monsterLevel = MIN_LEVEL + 1;

        if (heroLevel >= 2 && heroLevel <= 10) {
            monsterLevel = heroLevel + (MIN_RAND_LEVEL_LOW + (int) (Math.random() *
                    ((MAX_RAND_LEVEL_LOW - (MIN_RAND_LEVEL_LOW)) + MAX_RAND_LEVEL_LOW)));

        } else if (heroLevel > 10 && heroLevel <= 18) {
            monsterLevel = heroLevel + (MIN_RAND_LEVEL_MIDDLE + (int) (Math.random() *
                    ((MAX_RAND_LEVEL_MIDDLE - (MIN_RAND_LEVEL_MIDDLE)) + MAX_RAND_LEVEL_MIDDLE)));

        } else if (heroLevel > 18) {
            monsterLevel = heroLevel + (MIN_RAND_LEVEL_HIGH + (int) (Math.random() *
                    ((MAX_RAND_LEVEL_HIGH - (MIN_RAND_LEVEL_HIGH)) + MAX_RAND_LEVEL_HIGH)));
        }

        return monsterLevel;
    }
}
