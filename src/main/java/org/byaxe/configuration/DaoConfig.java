package org.byaxe.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.byaxe.data.dao.implementation"})
public class DaoConfig {

}
