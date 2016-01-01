package aspects;

import creations.implementLevel.Hero;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HeroWatcher {

    @Pointcut("execution(* creations.implementLevel.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }


    @Around(value = "enter(hero)", argNames = "joinPoint,hero")
    public Object watchEnter(ProceedingJoinPoint joinPoint, Hero hero) {
        Object result = null;
        try {
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("" + hero.getName() + ", you have " + hero.getCurrentHP() + "/" + hero.getMaxHP() +
                    " HP & " + hero.getCurrentMP() + "/" + hero.getMaxMP() + " MP" +
                    "\nYour lvl is - " + hero.getLevel());
            System.out.println("STR: " + hero.getStrength() + " AGL: " + hero.getAgility());
            System.out.println("-----------------------------------------------------------------------------------");
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
