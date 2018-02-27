package com.siwoo.application.service;

import com.siwoo.application.config.SpringDataJpaConfig;
import com.siwoo.application.domain.SingerAudit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataJpaConfig.class)
public class SpringAuditJpaDemo {

    @Autowired SingerAuditService singerAuditService;

    @Test
    public void testAudit(){

        singerAuditService.findAll().stream().map(SingerAudit::toString).forEach(log::warn);
    }
}
