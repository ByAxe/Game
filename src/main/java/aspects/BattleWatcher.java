package aspects;

import creations.implementLevel.Hero;
import creations.implementLevel.Monster;
import data.SystemData;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import static data.SystemData.QUESTION_FIGHT_OR_RUN;
import static regular.expression.RegExp.FIGHT_IF_TRUE;
import static regular.expression.RegExp.checkOnCorrectValue;

@Aspect
public class BattleWatcher {

    private Monster monster;

    @Autowired
    private SystemData systemData;

    @Pointcut("execution(* creations.implementLevel.Hero.startBattle()) && target(hero)")
    public void startBattle(Hero hero) {
    }

    @Before(value = "startBattle(hero)", argNames = "hero")
    public void meetingWithMonster(final Hero hero) {

        monster = systemData.createMonster(hero);
        System.out.println(systemData.chooseMessageAboutMonsterDependsOnLevel(monster, hero));

        if ("run".equalsIgnoreCase(checkOnCorrectValue(QUESTION_FIGHT_OR_RUN, FIGHT_IF_TRUE))) {
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


    public void fight(final Hero hero) {
        /*TODO add fight logic*/
    }
}