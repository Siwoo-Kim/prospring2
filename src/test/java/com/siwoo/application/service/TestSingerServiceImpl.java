package com.siwoo.application.service;

import com.siwoo.application.config.JpaConfig;
import com.siwoo.application.domain.Album;
import com.siwoo.application.domain.Singer;
import com.siwoo.application.view.SingerSummary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaConfig.class)
public class TestSingerServiceImpl {

    @Autowired SingerServiceImpl singerService;

    public static Consumer<List<Singer>> listSinger = singers -> {
        System.out.println("--- Listing singers: ");
        singers.forEach(System.out::println);
    };

    public static Consumer<List<SingerSummary>> listSingerSummary = summary -> {
        System.out.println("--- Listing Summary: ");
        summary.forEach(System.out::println);
    };
    public static Consumer<List<Singer>> listSingerWithAlbums = singers -> {
        System.out.println("--- Listing singers: ");
        for(Singer singer : singers){
            System.out.printf(singer.toString());
            if(singer.getAlbums() != null){
                singer.getAlbums().forEach(album -> System.out.printf("\t"+album));
            }
            if(singer.getInstruments() != null){
                singer.getInstruments().forEach(instrument -> System.out.printf("\t"+instrument));
            }
            System.out.println();
        }

    };


    @Test
    public void testFindAll(){
        assertEquals(singerService.findAll().size(),3,0);
        listSinger.accept(singerService.findAll());
    }

    @Test
    public void testFindAllWithAlbum(){
        assertEquals(singerService.findAllWithAlbum().size(),3,0);
        listSingerWithAlbums.accept(singerService.findAllWithAlbum());
    }

    @Test
    public void testFindById(){
        assertNotNull(singerService.findById(1L));
        System.out.println(singerService.findById(1l));
    }

    @Autowired SingerSummaryService singerSummaryService;

    @Test
    public void testDisplaySummary(){
        singerSummaryService.dispalySummary();
    }

    @Test
    public void testFindAllSummary(){
        assertEquals(singerSummaryService.findAll().size(),2,0);
        listSingerSummary.accept(singerSummaryService.findAll());
    }

    @Test
    public void testInsert(){
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("king");
        singer.setBirthDate(LocalDate.of(1940, 8, 16));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(LocalDateTime.now());
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(LocalDateTime.now());
        singer.addAlbum(album);

        singerService.save(singer);
        assertNotNull(singer.getId());

        assertEquals(singerService.findAll().size(),4,0);
        singerService.findAllWithAlbum().stream()
                .filter(s -> s.getId().equals(singer.getId()) )
                .forEach(s ->
                {
                    assertEquals(s.getAlbums().size(),2);
                    System.out.println(s.getAlbums().toString());
                });
    }

    @Test
    public void testFindByCriteriaQuery(){
        List<Singer> singers = singerService.findByCriteriaQuery("John","Mayer");
        assertEquals(singers.size(),1);
        listSinger.accept(singers);
    }
}



















