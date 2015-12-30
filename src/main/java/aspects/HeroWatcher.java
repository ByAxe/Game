package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HeroWatcher {

    @Pointcut("execution(* creations.Hero.enter(..))")
    public void actions(){}

    @Around("actions()")
    public void watchEnter(ProceedingJoinPoint joinPoint){
        /*TODO Add here functionality*/
        try {
            joinPoint.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
