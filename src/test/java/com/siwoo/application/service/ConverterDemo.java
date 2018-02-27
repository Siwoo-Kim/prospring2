package com.siwoo.application.service;

import com.siwoo.application.config.AppConfig;
import com.siwoo.application.domain.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ConverterDemo {

    @Autowired
    Singer john;

    @Test
    public void testConvert(){
        assertNotNull(john);
        System.out.println(john);
    }
}
