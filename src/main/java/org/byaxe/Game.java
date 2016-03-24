package org.byaxe;

import org.byaxe.configuration.AppConfig;
import org.byaxe.data.dao.interfaces.IHeroDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.byaxe.data.SystemData.MAIN_QUESTION;
import static org.byaxe.regular.expression.RegExp.*;

public class Game {
    public static void main(String[] args) {
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        final IHeroDAO hero = (IHeroDAO) context.getBean("hero");
        final Cycle cycle = new Cycle();

/*        Thread intro = new Thread(new Introduction("Introduction"));
        intro.start();

        try {
            intro.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);

        hero.enter();

        for (int i = 0; ; ++i) {
            if (i == 1) {
                /*Thread firstMeeting = new Thread(new FirstMeeting("First Meeting"));
                firstMeeting.start();

                try {
                    firstMeeting.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

            cycle.choice(checkOnCorrectValue(MAIN_QUESTION, A_B_C), hero);
        }
    }

}