package org.byaxe;

import org.byaxe.aspects.BattleWatcher;
import org.byaxe.aspects.HeroMovesWatcher;
import org.byaxe.aspects.InventoryWatcher;
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

    @Bean
    public InventoryWatcher inventoryWatcher() {
        return new InventoryWatcher();
    }

    @Bean
    public HeroMovesWatcher heroMovesWatcher(){
        return new HeroMovesWatcher();
    }
}
