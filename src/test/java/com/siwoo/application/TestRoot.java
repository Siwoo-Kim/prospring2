package com.siwoo.application;

import com.siwoo.application.config.JpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestRoot {

    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void test(){
        assertNotNull(applicationContext.getBean(DataSource.class));
    }
}
