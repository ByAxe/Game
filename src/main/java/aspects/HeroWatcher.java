package aspects;

import creations.AbstractHero;
import creations.Hero;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HeroWatcher {

/*    @Pointcut("execution(* creations.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }


//    TODO I have to solve this problem at an early date

    @Around(value = "enter(hero)", argNames = "joinPoint,hero")
    public void watchEnter(ProceedingJoinPoint joinPoint, AbstractHero hero) {
        try {
            System.out.println(hero.getName() + " you have " + hero.getHP() + " HP & " + hero.getMP()
                    + "\n your lvl is " + hero.getLevel());
            System.out.println("STR: " + hero.getStrength() + " AGL: " + hero.getAgility());

            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }*/
}
