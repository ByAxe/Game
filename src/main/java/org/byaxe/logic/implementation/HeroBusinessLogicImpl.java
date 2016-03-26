package org.byaxe.logic.implementation;

import org.byaxe.data.dao.implementation.EffectsDAOImpl;
import org.byaxe.data.dao.implementation.SkillsDAOImpl;
import org.byaxe.data.entities.EffectsEntity;
import org.byaxe.data.entities.SkillsEntity;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.heroes.ParametersEntity;
import org.byaxe.data.entities.equipment.AbstractEquipmentEntity;
import org.byaxe.exceptions.*;
import org.byaxe.logic.interfaces.IHeroBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by byaxe on 3/25/16.
 */
@Component
public class HeroBusinessLogicImpl implements IHeroBusinessLogic {

    @Autowired
    EffectsDAOImpl effects;

    @Autowired
    SkillsDAOImpl skills;

    private Set<EffectsEntity> heroEffects;
    private Set<SkillsEntity> heroSkills;

    private EffectsEntity targetEffect;
    private SkillsEntity targetSkill;

    public void enter(HeroesEntity hero) {
    }

    public boolean run(HeroesEntity hero) {
        return true;
    }

    public void startBattle(HeroesEntity hero) {

    }

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

    public AbstractEquipmentEntity setEquipment(final AbstractEquipmentEntity equipment, HeroesEntity hero)
            throws WeakHeroException {
        checkOnPower(equipment, hero);

        checkOnPower(equipment, hero);

        return null;
    }

    public String getInfoAboutParameters(final HeroesEntity hero) {
        final ParametersEntity heroParameters = hero.getParameters();

        String resultMessage = "-----------------------------------------------------------------------------------";

        resultMessage += "\n" + hero.getName() + ", your level is - " + hero.getLvl();
        resultMessage += "\nYou have: " + heroParameters.getCurrentHp() + "/" + heroParameters.getHp() + " HP";
        resultMessage += " & " + heroParameters.getCurrentMp() + "/" + heroParameters.getMp() + " MP";
        resultMessage += "\nSTR: " + heroParameters.getCurrentStrength() + "/" + heroParameters.getStrength();
        resultMessage += "; AGL: " + heroParameters.getCurrentAgility() + "/" + heroParameters.getAgility();
        resultMessage += "; INT: " + heroParameters.getCurrentIntellect() + "/" + heroParameters.getIntellect();

        resultMessage += "\n-----------------------------------------------------------------------------------";

        return resultMessage;
    }

    public String getInfoAboutArmor(final HeroesEntity hero) {
        return hero.getArmor().toString();
    }

    public String getInfoAboutWeapon(final HeroesEntity hero) {
        return hero.getWeapon().toString();
    }

    public String getInfoAboutEquipment(final HeroesEntity hero) {
        return getInfoAboutArmor(hero) + getInfoAboutWeapon(hero);
    }

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
