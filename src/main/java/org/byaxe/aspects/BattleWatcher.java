package org.byaxe.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.byaxe.data.SystemData;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;
import org.byaxe.logic.implementation.HeroBusinessLogicImpl;
import org.byaxe.logic.implementation.MonsterBusinessLogicImpl;
import org.springframework.beans.factory.annotation.Autowired;

import static org.byaxe.data.SystemData.QUESTION_ABOUT_FIGHT;
import static org.byaxe.regular.expression.RegExp.FIGHT_IF_TRUE;
import static org.byaxe.regular.expression.RegExp.checkOnCorrectValue;

@Aspect
public class BattleWatcher {

    private MonstersEntity monster;

    @Autowired
    private MonsterBusinessLogicImpl monsterBusinessLogic;

    @Autowired
    private HeroBusinessLogicImpl heroBusinessLogic;

    @Autowired
    private SystemData systemData;

    @Pointcut("execution(* org.byaxe.logic.implementation.HeroBusinessLogicImpl.startBattle()) && args(hero)")
    public void startBattle(HeroesEntity hero) {
    }

    @Before(value = "startBattle(hero)", argNames = "hero")
    public void meetingWithMonster(final HeroesEntity hero) {

        monster = monsterBusinessLogic.getMonsterDependsOnHero(hero);
        System.out.println(systemData.chooseMessageAboutMonsterDependsOnHeroLevel(monster, hero));

        if ("run".equalsIgnoreCase(checkOnCorrectValue(QUESTION_ABOUT_FIGHT, FIGHT_IF_TRUE))) {
            fight(hero);
        } else {
            System.out.println("Let's get out of here!\n");
            if (!heroBusinessLogic.run(hero)) {
                System.out.println("Something went wrong, and you cannot run away..." +
                        "The only way - is fight.\n");
                fight(hero);
            }
        }
    }


    private void fight(HeroesEntity hero) {
        /*TODO add fight logic*/
    }
}