package configuration;

import aspects.HeroWatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = {HeroWatcher.class})
@EnableAspectJAutoProxy
public class AspectConfig {

/*    @Bean
    public HeroWatcher heroWatcher() {
        return new HeroWatcher();
    }*/
}
