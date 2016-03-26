package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IHeroDAO;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.springframework.stereotype.Repository;

/**
 * Created by byaxe on 3/21/16.
 */
@Repository
public class HeroDAOImpl extends GenericAbstractDAO implements IHeroDAO {


    @Override
    public HeroesEntity saveOrUpdateHero(final HeroesEntity hero) {
        return entityManager.merge(hero);
    }

    @Override
    public HeroesEntity getHeroById(int id) {
        return entityManager.createQuery("SELECT h FROM HeroesEntity h" +
                " WHERE id = " + id, HeroesEntity.class).getSingleResult();
    }
}