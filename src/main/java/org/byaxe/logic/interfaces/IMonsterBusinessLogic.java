package org.byaxe.logic.interfaces;

import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;

/**
 * Created by byaxe on 26.03.16.
 */
public interface IMonsterBusinessLogic {

    MonstersEntity getMonsterDependsOnHero(final HeroesEntity hero);

}
