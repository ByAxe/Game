package org.byaxe;

import org.byaxe.configuration.AppConfig;
import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.logic.implementation.HeroBusinessLogicImpl;
import org.byaxe.logic.interfaces.IHeroBusinessLogic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.byaxe.data.SystemData.MAIN_QUESTION;
import static org.byaxe.regular.expression.RegExp.*;

public class Game {
    public static void main(String[] args) {
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HeroesEntity hero = (HeroesEntity) context.getBean("hero");
        final IHeroBusinessLogic heroBusinessLogic = (HeroBusinessLogicImpl) context.getBean("heroBusinessLogic");
        final Cycle cycle = new Cycle();

///*        Thread intro = new Thread(new Introduction("Introduction"));
//        intro.start();
//
//        try {
//            intro.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }*/
        checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);

        heroBusinessLogic.enter(hero);

        for (int i = 0; ; ++i) {
            if (i == 1) {
//                Thread firstMeeting = new Thread(new FirstMeeting("First Meeting"));
//                firstMeeting.start();
//
//                try {
//                    firstMeeting.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }

            cycle.choice(checkOnCorrectValue(MAIN_QUESTION, A_B_C), hero);
        }
    }

}