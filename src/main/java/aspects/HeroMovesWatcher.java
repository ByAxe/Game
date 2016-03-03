package aspects;

import creations.implementLevel.Hero;
import data.SystemData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadLocalRandom;

import static regular.expression.RegExp.YES_NO;
import static regular.expression.RegExp.checkOnCorrectValue;

@Aspect
public class HeroMovesWatcher {

    @Autowired
    private SystemData systemData;

    @Pointcut("execution(* creations.implementLevel.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }

    @Pointcut("execution(* creations.implementLevel.Hero.escape()) && target(hero)")
    public void escape(Hero hero) {
    }

    @Before(value = "enter(hero)", argNames = "hero")
    public void watchEnter(final Hero hero) {
        if ("yes".equalsIgnoreCase(checkOnCorrectValue(
                "Do want to find out something about your statement?\t", YES_NO))) {
            /*TODO add choice: info either about equipment or about skills or about characteristics*/
            systemData.infoAboutHero(hero);
        }
    }

    @Around(value = "escape(hero)", argNames = "pjp,hero")
    public boolean tryToEscape(final ProceedingJoinPoint pjp, final Hero hero) {
        boolean result = true;
        try {
            result = (boolean) pjp.proceed();

            /*It is just 20% possibility that hero couldn't run away*/
            if (ThreadLocalRandom.current().nextInt(1, 10) > 2) result = false;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}