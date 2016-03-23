package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IHeroDAO;
import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.SkillsEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.exceptions.AlreadyContainsException;
import org.byaxe.exceptions.NotContainsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Created by byaxe on 3/21/16.
 */
@Repository
public class HeroDAOImpl extends GenericAbstractDAO implements IHeroDAO {

    @Autowired
    EffectsDAOImpl effects;

    @Autowired
    SkillsDAOImpl skills;

    private Set<EffectsEntity> heroEffects;
    private Set<SkillsEntity> heroSkills;

    private EffectsEntity targetEffect;
    private SkillsEntity targetSkill;

    @Override
    public HeroesEntity saveOrUpdateHero(final HeroesEntity hero) {
        return entityManager.merge(hero);
    }

    @Override
    public EffectsEntity addEffect(HeroesEntity hero, final int effectId)
            throws NoSuchElementException {
        heroEffects = hero.getEffects();

        if (effects.getListOfEffects().size() >= effectId) {
            targetEffect = effects.getEffectById(effectId);

            if (!heroEffects.contains(targetEffect)) {
                heroEffects.add(targetEffect);

                hero.setEffects(heroEffects);
            }
        } else {
            throw new NoSuchElementException();
        }
        return targetEffect;
    }

    @Override
    public EffectsEntity deleteEffect(HeroesEntity hero, final int effectId)
            throws NotContainsException, NoSuchElementException {
        heroEffects = hero.getEffects();

        if (effects.getListOfEffects().size() >= effectId) {
            targetEffect = effects.getEffectById(effectId);

            if (heroEffects.contains(targetEffect)) {
                heroEffects.remove(targetEffect);
            } else {
                throw new NotContainsException();
            }
        } else {
            throw new NoSuchElementException();
        }
        return targetEffect;
    }

    @Override
    public SkillsEntity addSkill(HeroesEntity hero, final int skillId)
            throws AlreadyContainsException, NoSuchElementException {
        heroSkills = hero.getSkills();

        if (skills.getListOfSkills().size() >= skillId) {
            targetSkill = skills.getSkillById(skillId);

            if (!heroSkills.contains(targetSkill)) {
                heroSkills.add(targetSkill);

                hero.setSkills(heroSkills);
            } else {
                throw new AlreadyContainsException();
            }
        } else {
            throw new NoSuchElementException();
        }

        return targetSkill;
    }

    @Override
    public SkillsEntity upgradeSkill(HeroesEntity hero, final int skillId)
            throws NotContainsException, NoSuchElementException {
        heroSkills = hero.getSkills();

        if (skills.getListOfSkills().size() >= skillId) {
            targetSkill = skills.getSkillById(skillId);

            if (heroSkills.contains(targetSkill)) {
                heroSkills.remove(targetSkill);

                targetSkill.setLevel(targetSkill.getLevel() + 1);
                heroSkills.add(targetSkill);

            } else {
                throw new NotContainsException();
            }
        } else {
            throw new NoSuchElementException();
        }

        return targetSkill;
    }
}