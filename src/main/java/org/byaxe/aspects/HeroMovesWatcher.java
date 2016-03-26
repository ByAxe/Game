package org.byaxe.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.logic.implementation.HeroBusinessLogicImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadLocalRandom;

import static org.byaxe.regular.expression.RegExp.YES_NO;
import static org.byaxe.regular.expression.RegExp.checkOnCorrectValue;

@Aspect
public class HeroMovesWatcher {

    @Autowired
    private HeroBusinessLogicImpl heroBusinessLogic;

    @Pointcut("execution(* org.byaxe.logic.implementation.HeroBusinessLogicImpl.enter()) && args(hero)")
    public void enter(HeroesEntity hero) {
    }

    @Pointcut("execution(* org.byaxe.logic.implementation.HeroBusinessLogicImpl.run()) && args(hero)")
    public void escape(HeroesEntity hero) {
    }

    @Before(value = "enter(hero)", argNames = "hero")
    public void watchEnter(final HeroesEntity hero) {
        if ("yes".equalsIgnoreCase(checkOnCorrectValue(
                "Do want to find out something about your statement?\t", YES_NO))) {
            /*TODO add choice: info either about equipment or about skills or about characteristics*/
            heroBusinessLogic.getInfoAboutHero(hero);
        }
    }

    @Around(value = "escape(hero)", argNames = "pjp,hero")
    public boolean tryToEscape(final ProceedingJoinPoint pjp, final HeroesEntity hero) {
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