package com.siwoo.application.formatter;

import com.siwoo.application.domain.Singer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/prop-editor-app-context.xml")
public class TestLocalDateEditor {

    @Autowired Singer eric;
    @Autowired Singer countrySinger;

    @Test
    public void testFormat(){
        assertNotNull(eric);
        log.warn("eric: "+eric);
        log.warn("countrySinger: "+countrySinger);

    }
}
