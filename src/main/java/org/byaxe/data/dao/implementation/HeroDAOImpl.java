package org.byaxe.data.dao.implementation;

import org.byaxe.data.dao.GenericAbstractDAO;
import org.byaxe.data.dao.interfaces.IHeroDAO;
import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.SkillsEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.heroes.ParametersEntity;
import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;
import org.byaxe.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by byaxe on 3/21/16.
 */
@Repository
public class HeroDAOImpl extends GenericAbstractDAO implements IHeroDAO {

    private String resultMessage;

    @Autowired
    EffectsDAOImpl effects;

    @Autowired
    SkillsDAOImpl skills;

    @Autowired
    HeroesEntity hero;

    private Set<EffectsEntity> heroEffects;
    private Set<SkillsEntity> heroSkills;

    private EffectsEntity targetEffect;
    private SkillsEntity targetSkill;

    @Override
    public void enter() {
    }

    @Override
    public void run() {
    }

    @Override
    public void escape() {

    }

    @Override
    public void startBattle() {

    }

    @Override
    public HeroesEntity saveOrUpdateHero(final HeroesEntity hero) {
        return entityManager.merge(hero);
    }

    @Override
    public EffectsEntity addEffect(HeroesEntity hero, final int effectId)
            throws IndexOutOfBoundsException {
        heroEffects = hero.getEffects();

        checkRange(effectId, effects.getListOfEffects().size());

        targetEffect = effects.getEffectById(effectId);

        if (!heroEffects.contains(targetEffect)) {
            heroEffects.add(targetEffect);

            hero.setEffects(heroEffects);
        }

        return targetEffect;
    }

    @Override
    public EffectsEntity deleteEffect(HeroesEntity hero, final int effectId)
            throws NotContainsException, IndexOutOfBoundsException {
        heroEffects = hero.getEffects();

        checkRange(effectId, effects.getListOfEffects().size());

        targetEffect = effects.getEffectById(effectId);

        if (heroEffects.contains(targetEffect)) {
            heroEffects.remove(targetEffect);
        } else {
            throw new NotContainsException();
        }

        return targetEffect;
    }

    @Override
    public SkillsEntity addSkill(HeroesEntity hero, final int skillId)
            throws AlreadyContainsException, IndexOutOfBoundsException {
        heroSkills = hero.getSkills();

        checkRange(skillId, skills.getListOfSkills().size());

        targetSkill = skills.getSkillById(skillId);

        if (!heroSkills.contains(targetSkill)) {
            heroSkills.add(targetSkill);

            hero.setSkills(heroSkills);
        } else {
            throw new AlreadyContainsException();
        }

        return targetSkill;
    }

    @Override
    public SkillsEntity upgradeSkill(HeroesEntity hero, final int skillId)
            throws NotContainsException, IndexOutOfBoundsException {
        heroSkills = hero.getSkills();

        checkRange(skillId, skills.getListOfSkills().size());

        targetSkill = skills.getSkillById(skillId);

        if (heroSkills.contains(targetSkill)) {
            heroSkills.remove(targetSkill);

            targetSkill.setLevel(targetSkill.getLevel() + 1);
            heroSkills.add(targetSkill);

        } else {
            throw new NotContainsException();
        }

        return targetSkill;
    }

    @Override
    public AbstractEquipmentEntity setEquipment(final AbstractEquipmentEntity equipment, HeroesEntity hero)
            throws WeakHeroException {
        checkOnPower(equipment, hero);

        checkOnPower(equipment, hero);

        return null;
    }

    @Override
    public String getInfoAboutParameters(final HeroesEntity hero) {
        final ParametersEntity heroParameters = hero.getParameters();

        resultMessage = "-----------------------------------------------------------------------------------";

        resultMessage += "\n" + hero.getName() + ", your level is - " + hero.getLvl();
        resultMessage += "\nYou have: " + heroParameters.getCurrentHp() + "/" + heroParameters.getHp() + " HP";
        resultMessage += " & " + heroParameters.getCurrentMp() + "/" + heroParameters.getMp() + " MP";
        resultMessage += "\nSTR: " + heroParameters.getCurrentStrength() + "/" + heroParameters.getStrength();
        resultMessage += "; AGL: " + heroParameters.getCurrentAgility() + "/" + heroParameters.getAgility();
        resultMessage += "; INT: " + heroParameters.getCurrentIntellect() + "/" + heroParameters.getIntellect();

        resultMessage += "\n-----------------------------------------------------------------------------------";

        return resultMessage;
    }

    @Override
    public String getInfoAboutArmor(final HeroesEntity hero) {
        return hero.getArmor().toString();
    }

    @Override
    public String getInfoAboutWeapon(final HeroesEntity hero) {
        return hero.getWeapon().toString();
    }

    @Override
    public String getInfoAboutEquipment(final HeroesEntity hero) {
        return getInfoAboutArmor(hero) + getInfoAboutWeapon(hero);
    }

    @Override
    public String getInfoAboutHero(final HeroesEntity hero) {
        return getInfoAboutParameters(hero) + getInfoAboutEquipment(hero);
    }

    private void checkRange(final int current, final int max) throws IndexOutOfBoundsException {
        if (max < current) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkOnPower(final AbstractEquipmentEntity equipment, HeroesEntity hero)
            throws WeakHeroException {
        ParametersEntity heroParameters = hero.getParameters();

        if (equipment.getRequiredLevel() > hero.getLvl()) throw new NotEnoughLevelException();

        if (equipment.getRequiredStrength() > heroParameters.getCurrentStrength() ||
                equipment.getRequiredAgility() > heroParameters.getCurrentAgility() ||
                equipment.getRequiredIntellect() > heroParameters.getCurrentIntellect()) {
            throw new LowParametersException();
        }
    }

}