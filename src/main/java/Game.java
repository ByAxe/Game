import abilities.regular.experience.RegExp;
import configuration.AppConfig;
import creations.Hero;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import text.EpicText;

import java.util.Scanner;

import static abilities.regular.experience.RegExp.YES;

public class Game {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scan = new Scanner(System.in);

        Hero hero = context.getBean(Hero.class);

        Thread thread = new Thread(new EpicText("Epic text"));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegExp.checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);

        System.out.println(hero.enter());
    }
}