package com.siwoo.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@Import({DataJpaConfig.class})
@ComponentScan("com.siwoo.application.service")
public class ServiceConfig {

    @Autowired
    EntityManagerFactory entityManagerFactory;


    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
