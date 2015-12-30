import abilities.regular.experience.RegExp;
import configuration.AppConfig;
import creations.Hero;
import data.TypeOfEquipment;
import equipment.AbstractEquipment;
import equipment.IEquipment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parser.MyParser;

import java.util.EnumMap;
import java.util.Scanner;

import static abilities.regular.experience.RegExp.NAME;
import static abilities.regular.experience.RegExp.YES;

public class Game {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scan = new Scanner(System.in);
        AbstractEquipment tempEq;

        MyParser myParser = context.getBean(MyParser.class);
        myParser.parseEquipment();

        EnumMap<TypeOfEquipment, IEquipment> heroStartEquipment = new EnumMap<>(TypeOfEquipment.class);

        tempEq = (AbstractEquipment) myParser.weaponTable.get(1);
        heroStartEquipment.put(tempEq.getTypeOfEquipment(), tempEq);

        tempEq = (AbstractEquipment) myParser.armorTable.get(1);
        heroStartEquipment.put(tempEq.getTypeOfEquipment(), tempEq);
        /*-----------------------------------------------------------*/

        Hero hero = new Hero(RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", NAME),
                heroStartEquipment, (byte) 1, 20, 100, 15, 15, null, 0);

        /*-----------------------------------------------------------*/

        System.out.println("\n\t..Once your teacher said to you: " + hero.getName() +
                ", while you won't be perfect -" +
                " you won't become the King.\n" +
                " Only the blood can make you strong enough for this..." +
                "Only the blood of your enemies on your weapon and face.\n " +
                "Go ahead, young hero and you will find your way.\n" +
                "At first - clear the labyrinth. It will be your first attempt to become an adult man...\n\t");
        System.out.println("\n..after a while..\n");
        RegExp.checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);
    }
}
