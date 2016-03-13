package org.byaxe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.byaxe.SystemData.QUESTION_WHEN_ENTER;
import static org.byaxe.expression.RegExp.*;

public class Game {
    public static void main(String[] args) {
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        final ICreation hero = (ICreation) context.getBean("hero");
        final Cycle cycle = new Cycle();

/*        Thread intro = new Thread(new Introduction("Introduction"));
        intro.start();

        try {
            intro.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);

        System.out.println(hero.enter());

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

            cycle.choice(checkOnCorrectValue(QUESTION_WHEN_ENTER, A_B_C), hero);
        }
    }

}