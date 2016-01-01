import configuration.AppConfig;
import creations.ICreation;
import data.texts.Introduction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import regular.expression.RegExp;

import java.util.Scanner;

import static regular.expression.RegExp.YES;

public class Game {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scan = new Scanner(System.in);

        ICreation hero = (ICreation) context.getBean("hero");

        Thread thread = new Thread(new Introduction("Epic text"));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegExp.checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);

        System.out.println(hero.enter());

        hero.attack();

    }
}