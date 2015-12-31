package aspects;

import creations.Hero;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HeroWatcher {

    @Pointcut("execution(* creations.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }


    @Around(value = "enter(hero)", argNames = "joinPoint,hero")
    public Object watchEnter(ProceedingJoinPoint joinPoint, Hero hero) {
        Object result = null;
        try {
            System.out.println("\n" + hero.getName() + ", you have " + hero.getHP() + " HP & " + hero.getMP() + " MP"
                    + "\nYour lvl is - " + hero.getLevel());
            System.out.println("STR: " + hero.getStrength() + " AGL: " + hero.getAgility());
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
