package configuration;

import aspects.BattleWatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    public BattleWatcher heroWatcher() {
        return new BattleWatcher();
    }
}
