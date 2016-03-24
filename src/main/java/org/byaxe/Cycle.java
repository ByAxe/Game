package org.byaxe;

import org.byaxe.creations.ICreation;
import org.byaxe.data.dao.interfaces.IHeroDAO;

public class Cycle {

    public void choice(final String answer, final IHeroDAO hero) {
        switch (answer) {
            case "a":
                ifEntered(hero);
                break;

            case "b":
                hero.getInfoAboutEquipment();
                /*TODO hero wants to change equipment?*/
                break;

            case "c":
                    /*TODO Add save logic*/
                break;
        }

    }

    private void ifEntered(final IHeroDAO hero) {
        hero.enter();
        hero.startBattle();
    }
}