package org.byaxe.configuration;

import org.byaxe.data.SystemData;
import org.springframework.context.annotation.*;

@Configuration
@Import({EquipmentConfig.class, HeroConfig.class, AspectConfig.class,
        MonsterConfig.class, AbilityConfig.class})
@ImportResource("classpath*:hibernate-config.xml")
public class AppConfig {

    @Bean
    @DependsOn("experienceTable")
    public SystemData systemData(){
        return new SystemData();
    }

/*
    @Bean
    public DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/game_db");
        ds.setUsername("root");
        ds.setPassword("root");

        return ds;
    }

    @Bean
    @DependsOn("dataSource")
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("org.byaxe.entities");
        factoryBean.setPersistenceUnitName("GAME_PERSISTENCE_UNIT");
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        JpaVendorAdapter va = new HibernateJpaVendorAdapter();

        ((HibernateJpaVendorAdapter) va).setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        ((HibernateJpaVendorAdapter) va).setShowSql(true);

        Map<String,String> map = new HashMap<>();
        map.put("hibernate.connection.zeroDateTimeBehavior", "convertToNull");
        map.put("hibernate.archive.autodetection", "class");

        factoryBean.setJpaPropertyMap(map);
        factoryBean.setJpaVendorAdapter(va);

        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    @DependsOn("entityManagerFactory")
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager tm = new JpaTransactionManager();

        tm.setEntityManagerFactory(entityManagerFactory());

        return tm;
    }

    @PersistenceContext(unitName="GAME_PERSISTENCE_UNIT")
    private EntityManager entityManager;
*/

/*
    public static void main(String[] args) {
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("sds");
    }
*/

}
