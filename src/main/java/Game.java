import abilities.regular.experience.RegExp;
import configuration.AppConfig;
import creations.Hero;
import data.TypeOfEquipment;
import equipment.AbstractEquipment;
import equipment.IEquipment;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import configuration.MyParserConfig;
import text.EpicText;

import java.util.EnumMap;
import java.util.Scanner;

import static abilities.regular.experience.RegExp.NAME;
import static abilities.regular.experience.RegExp.YES;

public class Game {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        Scanner scan = new Scanner(System.in);

/*        AbstractEquipment tempEq;

        MyParserConfig myParserConfig = context.getBean(MyParserConfig.class);

        EnumMap<TypeOfEquipment, IEquipment> heroStartEquipment = new EnumMap<>(TypeOfEquipment.class);

        tempEq = (AbstractEquipment) myParserConfig.weaponTable.get(1);
        heroStartEquipment.put(tempEq.getTypeOfEquipment(), tempEq);

        tempEq = (AbstractEquipment) myParserConfig.armorTable.get(1);
        heroStartEquipment.put(tempEq.getTypeOfEquipment(), tempEq);

        Hero hero = new Hero(RegExp.checkOnCorrectValue("Hi. Please, enter your name:\t", NAME),
                heroStartEquipment, (byte) 1, 20, 100, 15, 15, null, 0);*/

        /*-----------------------------------------------------------*/

        Thread thread = new Thread(new EpicText("Epic text"));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RegExp.checkOnCorrectValue("You see the entrance. Enter? (adventure start here)\n\t(yes) - ", YES);

//        hero.enter();
    }
}