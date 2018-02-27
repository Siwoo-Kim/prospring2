package com.siwoo.application.config;

import com.siwoo.application.domain.SingerAudit;
import com.siwoo.application.service.SingerAuditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Testing {
    private static Logger logger = LoggerFactory.getLogger(Testing.class);

    public static void main(String... args) {

        //GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/app-context-annotation.xml");
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataJpaConfig.class);

        SingerAuditService singerAuditService = ctx.getBean(SingerAuditService.class);

        List<SingerAudit> singers = singerAuditService.findAll();
        listSingers(singers);

        System.out.println("Add new singer");
        SingerAudit singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(LocalDateTime.now());
        singerAuditService.save(singer);
        singers = singerAuditService.findAll();
        listSingers(singers);

        singer = singerAuditService.findById(4l);
        System.out.println("");
        System.out.println("Singer with id 1:" + singer);
        System.out.println("");

        System.out.println("Update singer");
        singer.setFirstName("Riley B.");
        singerAuditService.save(singer);
        singers = singerAuditService.findAll();
        listSingers(singers);

        ctx.close();
    }

    private static void listSingers(List<SingerAudit> singers) {
        logger.info(" ---- Listing singers:");
        singers.forEach(s -> logger.info(s.toString()));
    }
}
