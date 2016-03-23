package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IMonsterDAO;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.byaxe.data.SystemData.chooseLevelOfEnemy;
import static org.byaxe.data.SystemData.randomDistribution;

/**
 * Created by byaxe on 3/21/16.
 */
@Repository
public class MonsterDAOImpl extends GenericAbstractDAO implements IMonsterDAO {

    @Override
    public List<MonstersEntity> getMonstersList() {
        return entityManager.createQuery("SELECT m from MonstersEntity m",
                MonstersEntity.class).getResultList();
    }

    @Override
    public MonstersEntity getMonster(final HeroesEntity hero) {
        final List<MonstersEntity> suitableMonsters = getMonstersList().stream()
                .filter(m -> m.getLvl() == chooseLevelOfEnemy(hero.getLvl()))
                .collect(toList());

        return suitableMonsters.get(randomDistribution(suitableMonsters.size()));
    }
}
