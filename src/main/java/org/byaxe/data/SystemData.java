package org.byaxe.data;

import org.byaxe.data.entities.creations.heroes.HeroesEntity;
import org.byaxe.data.entities.creations.monsters.MonstersEntity;
import org.springframework.stereotype.Component;

@Component
public class SystemData {

    public static final byte MIN_RAND_LEVEL_LOW = -1;
    public static final byte MAX_RAND_LEVEL_LOW = 1;

    public static final byte MIN_RAND_LEVEL_MIDDLE = -2;
    public static final byte MAX_RAND_LEVEL_MIDDLE = 2;

    public static final byte MIN_RAND_LEVEL_HIGH = -4;
    public static final byte MAX_RAND_LEVEL_HIGH = 4;

    public static final byte MIN_LEVEL = 0;
    public static final byte MAX_LEVEL = 98;

    public static final String MAIN_QUESTION = "Your next move is..." +
            "\n\t(a) Enter the room" +
            "\n\t(b) Check inventory" +
            "\n\t(c) Save & Exit" +
            "\n\t\t - ";

    public static final String QUESTION_ABOUT_FIGHT = "Start to fight, or run out?\t";

    public String chooseMessageAboutMonsterDependsOnHeroLevel(final MonstersEntity monster, final HeroesEntity hero) {
        String resultMessage = "You see the strange thing" +
                " into the darkest angle of the room... ";

        if (monster.getLvl() > hero.getLvl()) {
            resultMessage += "Oh, that is " + monster.getName() +
                    "!\n You are being scared a bit. That is kind of dangerous enemy for you now.";
        } else if (monster.getLvl() < hero.getLvl()) {
            resultMessage += "You see " + monster.getName() + ".\n" +
                    "That is very good training material. Let's send him into another place!";
        } else {
            resultMessage += "Good! " + monster.getName() + " is kind of worthy opponent for you.";
        }
        return resultMessage;
    }


}