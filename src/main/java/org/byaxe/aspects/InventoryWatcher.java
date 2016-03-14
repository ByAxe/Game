package org.byaxe.aspects;

import org.byaxe.creations.implementLevel.Hero;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static org.byaxe.data.InventoryInformation.additionalInformationAboutArmor;
import static org.byaxe.data.InventoryInformation.additionalInformationAboutWeapon;

@Aspect
public class InventoryWatcher {

    @Pointcut("execution(* org.byaxe.creations.implementLevel.Hero.checkInventory()) && target(hero)")
    public void inventory(Hero hero) {
    }

    @After(value = "inventory(hero)", argNames = "hero")
    public void additionalInformation(final Hero hero) {

        System.out.println(additionalInformationAboutWeapon(hero));
        System.out.println(additionalInformationAboutArmor(hero));

    }
}
