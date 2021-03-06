package org.byaxe.logic.interfaces;

import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.SkillsEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;
import org.byaxe.exceptions.AlreadyContainsException;
import org.byaxe.exceptions.NotContainsException;
import org.byaxe.exceptions.WeakHeroException;

/**
 * Created by byaxe on 3/25/16.
 */
public interface IHeroBusinessLogic {
    void enter(HeroesEntity hero);

    boolean run(HeroesEntity hero);

    void startBattle(HeroesEntity hero);

    EffectsEntity addEffect(HeroesEntity hero, final int effectId)
            throws IndexOutOfBoundsException;

    EffectsEntity deleteEffect(HeroesEntity hero, final int effectId)
            throws NotContainsException, IndexOutOfBoundsException;

    SkillsEntity addSkill(HeroesEntity hero, final int skillId)
            throws AlreadyContainsException, IndexOutOfBoundsException;

    SkillsEntity upgradeSkill(HeroesEntity hero, final int skillId)
            throws NotContainsException, IndexOutOfBoundsException;

    AbstractEquipmentEntity setEquipment(final AbstractEquipmentEntity equipment, HeroesEntity hero)
            throws WeakHeroException;

    String getInfoAboutParameters(final HeroesEntity hero);

    String getInfoAboutArmor(final HeroesEntity hero);

    String getInfoAboutWeapon(final HeroesEntity hero);

    String getInfoAboutEquipment(final HeroesEntity hero);

    String getInfoAboutHero(final HeroesEntity hero);
}
