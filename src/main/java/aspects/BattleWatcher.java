package aspects;

import creations.implementLevel.Hero;
import creations.implementLevel.Monster;
import data.SystemData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class BattleWatcher {

    private Monster monster;
    private Hero hero;

    @Autowired
    private SystemData systemData;

    @Pointcut("execution(* creations.implementLevel.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }

    @Pointcut("execution(* creations.implementLevel.Hero.startBattle()) && target(hero)")
    public void startBattle(Hero hero) {
    }

    @Around(value = "enter(hero)", argNames = "joinPoint,hero")
    public Object watchEnter(ProceedingJoinPoint joinPoint, final Hero hero) {
        this.hero = hero;
        Object result = null;
        try {
            systemData.infoAboutHero(hero);
            result = joinPoint.proceed();

            monster = systemData.createMonster(hero);
            System.out.println(systemData.chooseMessageAboutMonsterDependsOnLevel(monster, hero));

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }

    @Around(value = "startBattle(hero)", argNames = "pjp,hero")
    public Object watchBattle(ProceedingJoinPoint pjp, final Hero hero) {
        try {
            pjp.proceed();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return null;
    }
}