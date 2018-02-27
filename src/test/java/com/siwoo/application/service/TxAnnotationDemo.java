package com.siwoo.application.service;

import com.siwoo.application.config.ServiceConfig;
import com.siwoo.application.domain.Singer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.siwoo.application.service.TestSingerServiceImpl.listSinger;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class TxAnnotationDemo {

    @Autowired TransactionSingerService transactionSingerService;

    @Test
    public void test(){

        List<Singer> singerList = transactionSingerService.findAll();
        listSinger.accept(singerList);

        Singer singer = transactionSingerService.findById(1l);
        singer.setFirstName("John Clayton");
        singer.setLastName("Mayer");
        transactionSingerService.save(singer);
        System.out.println("Singer saved successfully: "+singer);

    }

    @Test
    public void testCountAll(){

        assertEquals(transactionSingerService.countAll(),3L);

    }
}
