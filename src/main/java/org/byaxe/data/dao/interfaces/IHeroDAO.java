package org.byaxe.data.dao.interfaces;

import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.SkillsEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.exceptions.AlreadyContainsException;
import org.byaxe.exceptions.NotContainsException;

import java.util.NoSuchElementException;

/**
 * Created by byaxe on 3/21/16.
 */
public interface IHeroDAO {

    HeroesEntity saveOrUpdateHero(final HeroesEntity hero);

    EffectsEntity addEffect(HeroesEntity hero, final int effectId) throws NoSuchElementException;

    EffectsEntity deleteEffect(HeroesEntity hero, final int effectId)
            throws NotContainsException, NoSuchElementException;

    SkillsEntity addSkill(HeroesEntity hero, final int skillId)
            throws AlreadyContainsException, NoSuchElementException;

    SkillsEntity upgradeSkill(HeroesEntity hero, final int skillId)
            throws NotContainsException, NoSuchElementException;

    default void enter() {
    }

    default void run() {
    }
}
