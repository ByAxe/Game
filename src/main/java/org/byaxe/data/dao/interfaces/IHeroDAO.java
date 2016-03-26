package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.creations.heroes.HeroesEntity;

/**
 * Created by byaxe on 3/21/16.
 */
public interface IHeroDAO {

    HeroesEntity saveOrUpdateHero(final HeroesEntity hero);

    HeroesEntity getHeroById(final int id);
}
