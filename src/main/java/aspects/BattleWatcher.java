package aspects;

import configuration.EquipmentConfig;
import configuration.MonsterConfig;
import creations.implementLevel.Hero;
import creations.implementLevel.Monster;
import data.TypeOfEquipment;
import equipment.IEquipment;
import equipment.abstractLevel.AbstractEquipment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.EnumMap;

import static data.SystemData.*;

@Aspect
public class BattleWatcher {

    private Monster monster;
    private Hero hero;

    @Pointcut("execution(* creations.implementLevel.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }

    @Around(value = "enter(hero)", argNames = "joinPoint,hero")
    public Object watchEnter(ProceedingJoinPoint joinPoint, Hero hero) {
        this.hero = hero;
        Object result = null;
        try {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("" + hero.getName() + ", you have " + hero.getCurrentHP() + "/" + hero.getMaxHP() +
                    " HP & " + hero.getCurrentMP() + "/" + hero.getMaxMP() + " MP" +
                    "\nYour lvl is - " + hero.getLevel());
            System.out.println("STR: " + hero.getStrength() + " AGL: " + hero.getAgility());
            System.out.println("-----------------------------------------------------------------------------------");
            result = joinPoint.proceed();
            createMonster();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    @Pointcut("execution(* creations.implementLevel.Hero.startBattle()) && target(hero)")
    public void startBattle(Hero hero) {
    }

    @Around(value = "startBattle(hero)", argNames = "joinPoint,hero")
    public void battle(ProceedingJoinPoint joinPoint, Hero hero) {

        /*TODO Now - monster will have equal level to Hero because them are barely 10*/

/*        int counter = 0;

        monster = (Monster) (new MonsterConfig()).monstersTable.get(hero.getLevel());

        EnumMap<TypeOfEquipment, IEquipment> equipment = new EnumMap<>(TypeOfEquipment.class);

        for (Map.Entry<Integer, IEquipment> entry : (new EquipmentConfig()).weaponTable.entrySet()) {
            if (((AbstractEquipment)entry.getValue()).getRequiredLevel() == hero.getLevel()){
                equipment.put(++counter, entry.getValue());
            }
        }

        monster.setEquipmentMap();*/
    }

    private void createMonster() {
        monster = (Monster) (new MonsterConfig()).monstersTable.get(chooseLevel(hero.getLevel()));
        EnumMap<TypeOfEquipment, IEquipment> eqMap = new EnumMap<>(TypeOfEquipment.class);

        (new EquipmentConfig()).weaponTable.entrySet().stream()
                .filter(entry -> ((AbstractEquipment) entry.getValue()).getRequiredLevel() == (hero.getLevel() - 1))
                .forEach(entry -> {
                    eqMap.put(((AbstractEquipment) entry.getValue()).getTypeOfEquipment(), entry.getValue());
                });

        monster.setEquipmentMap(eqMap);
    }

    private int chooseLevel(int heroLevel) {
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
}