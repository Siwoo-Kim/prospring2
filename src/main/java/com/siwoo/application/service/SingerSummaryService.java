package com.siwoo.application.service;

import com.siwoo.application.view.SingerSummary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service @Repository @Transactional(readOnly = true)
public class SingerSummaryService {

    @PersistenceContext EntityManager entityManager;

    public void dispalySummary(){
        List<Object[]> rows = entityManager.createQuery(
                "select s.firstName, s.lastName, a.title from Singer s " +
                        "left outer join s.albums a " +
                        "where a.releaseDate = (select max(a2.releaseDate) from Album a2 " +
                        "where a2.singer.id = s.id )"
        ).getResultList();

        int count = 0;
        for(Object[] row: rows){
            System.out.println(++count+": "+row[0]+", "+row[1]+", "+row[2]);
        }
    }

    public List<SingerSummary> findAll(){
        return entityManager.createQuery(
                "select " +
                        "new com.siwoo.application.view.SingerSummary(s.firstName, s.lastName, a.title) " +
                        "from Singer s left outer join s.albums a " +
                        "where a.releaseDate = (select max(a2.releaseDate) from Album a2 " +
                        "where a2.singer.id = s.id )",
                SingerSummary.class).getResultList();
    }
}
