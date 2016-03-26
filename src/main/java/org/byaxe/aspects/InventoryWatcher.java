package org.byaxe.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.logic.implementation.HeroBusinessLogicImpl;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class InventoryWatcher {

    @Autowired
    private HeroBusinessLogicImpl heroBusinessLogic;

    @Pointcut("execution(* org.byaxe.logic.implementation.HeroBusinessLogicImpl.get*()) && args(hero)")
    public void inventory(HeroesEntity hero) {
    }

    @After(value = "inventory(hero)", argNames = "hero")
    public void additionalInformation(final HeroesEntity hero) {

        System.out.println(heroBusinessLogic.getInfoAboutEquipment(hero));

    }
}
