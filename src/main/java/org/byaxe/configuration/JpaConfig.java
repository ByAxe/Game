package org.byaxe.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by byaxe on 3/22/16.
 */
@Configuration
public class JpaConfig {
    @Bean(name = "DS")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/game_db");
        dataSource.setUsername("byaxe");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean(name = "JVA")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        adapter.setDatabasePlatform("POSTGRESQL");
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQL92Dialect");

        return adapter;
    }

    @Bean(name = "EMF")
    @DependsOn({"DS", "JVA"})
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource, JpaVendorAdapter vendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();

        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(vendorAdapter);
        emfb.setPackagesToScan("org.byaxe.entities");
        emfb.setPersistenceUnitName("GAME_PERSISTENCE_UNIT");

        return emfb;
    }

    @Bean(name = "TM")
    @DependsOn("EMF")
    public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf){
        JpaTransactionManager jtm = new JpaTransactionManager();

        jtm.setEntityManagerFactory(emf.getNativeEntityManagerFactory());

        return jtm;
    }
}
