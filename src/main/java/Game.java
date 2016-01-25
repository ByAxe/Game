import configuration.AppConfig;
import creations.ICreation;
import data.texts.Introduction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import regular.expression.RegExp;

public class Game {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ICreation hero = (ICreation) context.getBean("hero");

        Thread intro = new Thread(new Introduction("Introduction"));
        intro.start();

        try {
            intro.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegExp.checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", RegExp.YES);

        System.out.println(hero.enter());


        for (int i = 0; true; ++i) {
            String actions;
            if (i == 1) {
                /*Thread firstMeeting = new Thread(new FirstMeeting("First Meeting"));
                firstMeeting.start();

                try {
                    firstMeeting.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            actions = RegExp.checkOnCorrectValue("What are you going to do now?" +
                            "\n\t(a) Enter the room" +
                            "\n\t(b) Check inventory" +
//                    "\n\t(c) Save & Exit" +
                            "\n\t\t - ",
                    RegExp.ABC);

            switch (actions) {
                case "a":
                    System.out.println(hero.enter());

                    hero.startBattle();

                    break;
                case "b":
                    System.out.println(hero.checkInventory());
                    break;
                case "c":
                    /*TODO Add save logic*/
                    break;
            } // end::Main question
        } // end::Main loop
    }

}