package org.byaxe.data;

import org.byaxe.configuration.EquipmentConfig;
import org.byaxe.creations.ICreation;
import org.byaxe.creations.implementLevel.Hero;
import org.byaxe.creations.implementLevel.Monster;
import org.byaxe.equipment.IEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.TreeMap;

@Component
public class SystemData {

    public static final double PERFORMANCE_FACTOR = 0.1;

    public static final byte MIN_RANDOM_DAMAGE = -5;
    public static final byte MAX_RANDOM_DAMAGE = 5;

    public static final byte MIN_RAND_LEVEL_LOW = -1;
    public static final byte MAX_RAND_LEVEL_LOW = 1;

    public static final byte MIN_RAND_LEVEL_HIGH = -2;
    public static final byte MAX_RAND_LEVEL_HIGH = 2;

    public static final byte MIN_LEVEL = 1;
    public static final byte MAX_LEVEL = 10;

    public static final String FILE_EQUIPMENT = Paths.get("src/main/resources", "equipment.txt").toString();
    public static final String FILE_MONSTERS = Paths.get("src/main/resources", "monsters.txt").toString();


    public static final String QUESTION_WHEN_ENTER = "What are you going to do now?" +
            "\n\t(a) Enter the room" +
            "\n\t(b) Check inventory" +
            "\n\t(c) Save & Exit" +
            "\n\t\t - ";
    public static final String QUESTION_FIGHT_OR_RUN = "Start to fight, or run out?\t";

    @Autowired
    @Qualifier("monstersParser")
    private TreeMap<Integer, ICreation> monstersTable;

    @Autowired
    @Qualifier("experienceTable")
    private HashMap<Byte, Integer> requiredExperience;

    @Autowired
    private EquipmentConfig equipmentConfig;


    public static int randomDistribution() {
        return MIN_RANDOM_DAMAGE + (int) (Math.random() * ((MAX_RANDOM_DAMAGE - MIN_RANDOM_DAMAGE) + 1));
    }

    public Integer getRequiredExperience(final byte level) {
        return requiredExperience.get(level);
    }

    public int chooseLevelOfTheEnemy(final byte heroLevel) {
        int monsterLevel = MIN_LEVEL;

        if (heroLevel >= 2 && heroLevel <= 6) {
            monsterLevel = heroLevel + (MIN_RAND_LEVEL_LOW + (int) (Math.random() *
                    ((MAX_RAND_LEVEL_LOW - (MIN_RAND_LEVEL_LOW)) + MAX_RAND_LEVEL_LOW)));

        } else if (heroLevel > 6 && heroLevel <= 9) {
            monsterLevel = heroLevel + (MIN_RAND_LEVEL_HIGH + (int) (Math.random() *
                    ((MAX_RAND_LEVEL_HIGH - (MIN_RAND_LEVEL_HIGH)) + MAX_RAND_LEVEL_HIGH)));

        } else if (heroLevel == MAX_LEVEL) monsterLevel = MAX_LEVEL;

        return monsterLevel;
    }

    public String chooseMessageAboutMonsterDependsOnLevel(final Monster monster, final Hero hero) {
        String resultMessage = "You see the strange thing" +
                " into the darkest angle of the room... ";

        if (monster.getLevel() > hero.getLevel()) {
            resultMessage += "Oh, that is " + monster.getName() +
                    "!\n You are being scared a bit. That is kind of dangerous enemy for you now.";
        } else if (monster.getLevel() < hero.getLevel()) {
            resultMessage += "You see " + monster.getName() + ".\n" +
                    "That is very good training material. Let's send him into another place!";
        } else {
            resultMessage += "Good! " + monster.getName() + " is kind of worthy opponent for you.";
        }
        return resultMessage;
    }

    public Monster createMonster(final Hero hero) {
        Monster monster = (Monster) (monstersTable.get(chooseLevelOfTheEnemy(hero.getLevel())));
        EnumMap<TypeOfEquipment, IEquipment> eqMap = new EnumMap<>(TypeOfEquipment.class);

        equipmentConfig.weaponTable.entrySet().stream()
                .filter(entry -> entry.getValue().getRequiredLevel() == (hero.getLevel() - 1))
                .forEach(entry -> eqMap.put(entry.getValue().getTypeOfEquipment(), entry.getValue()));

        monster.setEquipmentMap(eqMap);
        return monster;
    }

    public void infoAboutHero(final Hero hero) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("" + hero.getName() + ", you have " + hero.getCurrentHP() + "/" + hero.getMaxHP() +
                " HP & " + hero.getCurrentMP() + "/" + hero.getMaxMP() + " MP" +
                "\nYour lvl is - " + hero.getLevel());
        System.out.println("STR: " + hero.getStrength() + " AGL: " + hero.getAgility());
        System.out.println("-----------------------------------------------------------------------------------");
    }


}