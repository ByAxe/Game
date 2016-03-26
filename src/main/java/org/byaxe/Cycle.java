package org.byaxe;

import org.byaxe.data.dao.interfaces.IHeroDAO;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.logic.interfaces.IHeroBusinessLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cycle {

    @Autowired
    IHeroBusinessLogic heroBusinessLogic;

    @Autowired
    IHeroDAO heroDAO;

    public void choice(final String answer, HeroesEntity hero) {
        switch (answer) {
            case "a":
                ifEntered(hero);
                break;

            case "b":
                heroBusinessLogic.getInfoAboutEquipment(hero);
                /*TODO hero wants to change equipment?*/
                break;

            case "c":
                    /*TODO Add save logic*/
                break;
        }

    }

    private void ifEntered(final HeroesEntity hero) {
        heroBusinessLogic.enter(hero);
        heroBusinessLogic.startBattle(hero);
    }
}