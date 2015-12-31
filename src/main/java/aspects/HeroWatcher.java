package aspects;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class HeroWatcher {

/*    @Pointcut("execution(* creations.Hero.enter()) && target(hero)")
    public void enter(Hero hero) {
    }


//    TODO I have to solve this problem at an early date

    @Around("enter(hero)")
    public void watchEnter(ProceedingJoinPoint joinPoint, Hero hero) {
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
