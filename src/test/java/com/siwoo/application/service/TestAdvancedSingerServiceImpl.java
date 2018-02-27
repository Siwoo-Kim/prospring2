package com.siwoo.application.service;

import com.siwoo.application.config.SpringDataJpaConfig;
import com.siwoo.application.domain.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static com.siwoo.application.service.TestSingerServiceImpl.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataJpaConfig.class)
public class TestAdvancedSingerServiceImpl {

    @Autowired AdvancedSingerServiceImpl advancedSingerService;

    @Test
    public void testFindAll(){
        List<Singer> singers = advancedSingerService.findAll();
        assertTrue(singers.size() > 0);
        listSinger.accept(singers);
    }

    @Test
    public void testFindByFirstName(){
        List<Singer> singers = advancedSingerService.findByFirstNameAndLastName("John","Mayer");
        assertTrue(singers.size() > 0);
        assertEquals(1,singers.size(),0);
        listSinger.accept(singers);
    }


}
