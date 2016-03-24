package org.byaxe.aspects;

import org.byaxe.creations.implementLevel.Hero;
import org.byaxe.creations.implementLevel.Monster;
import org.byaxe.data.SystemData;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import static org.byaxe.data.SystemData.QUESTION_ABOUT_FIGHT;
import static org.byaxe.regular.expression.RegExp.FIGHT_IF_TRUE;
import static org.byaxe.regular.expression.RegExp.checkOnCorrectValue;

@Aspect
public class BattleWatcher {

    private Monster monster;

    @Autowired
    private SystemData systemData;

    @Pointcut("execution(* org.byaxe.creations.implementLevel.Hero.startBattle()) && target(hero)")
    public void startBattle(Hero hero) {
    }

    @Before(value = "startBattle(hero)", argNames = "hero")
    public void meetingWithMonster(final Hero hero) {

        monster = systemData.createMonster(hero);
        System.out.println(systemData.chooseMessageAboutMonsterDependsOnHeroLevel(monster, hero));

        if ("run".equalsIgnoreCase(checkOnCorrectValue(QUESTION_ABOUT_FIGHT, FIGHT_IF_TRUE))) {
            fight(hero);
        } else {
            System.out.println("Let's get out of here!\n");
            if (!hero.escape()) {
                System.out.println("Something went wrong, and you cannot run away..." +
                        "The only way - is fight.\n");
                fight(hero);
            }
        }
    }


    private void fight(final Hero hero) {
        /*TODO add fight logic*/
    }
}