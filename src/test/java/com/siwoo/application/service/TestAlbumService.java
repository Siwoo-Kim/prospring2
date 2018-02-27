package com.siwoo.application.service;

import com.siwoo.application.config.SpringDataJpaConfig;
import com.siwoo.application.domain.Album;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataJpaConfig.class)
public class TestAlbumService {

    @Autowired AlbumService albumService;

    @Test
    public void testFindByTitle(){
        List<Album> albums = albumService.findByTitile("The");
        assertTrue(albums.size() > 0);
        assertEquals(albums.size(),2);

        albums.forEach(album -> {
            log.info(album.toString()+", Singer: "+album.getSinger().getFirstName()+" "+album.getSinger().getLastName());
        });
    }
}
