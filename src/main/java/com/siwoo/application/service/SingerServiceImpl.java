package com.siwoo.application.service;

import com.siwoo.application.domain.Singer;
import com.siwoo.application.domain.Singer_;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Slf4j
@Service @Transactional(readOnly = true) @Repository
public class SingerServiceImpl implements SingerService {

    private static final String SQL_FINDALL = "select id, first_name, last_name, birth_date, version from Singer";
    @PersistenceContext EntityManager entityManager;

    @Override
    public List<Singer> findAll() {
        return entityManager.createNamedQuery(Singer.JPQL_FINDALL,Singer.class).getResultList();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        return entityManager.createNamedQuery(Singer.JPQL_FINDALL_WITH_ALBUM,Singer.class)
                .getResultList();
    }

    @Override
    public Singer findById(Long id) {
        /*
            return entityManager.createNamedQuery(Singer.JPQL_FIND_BY_ID,Singer.class)
                    .setParameter("id",id)
                    .getSingleResult();
        */

        TypedQuery<Singer> typedQuery = entityManager.createNamedQuery(Singer.JPQL_FIND_BY_ID,Singer.class);
        typedQuery.setParameter("id",id);
        return typedQuery.getSingleResult();
    }

    @Override @Transactional(readOnly = false)
    public Singer save(Singer singer) {
        if(singer.getId() == null){
            log.info("Inserting new singer");
            entityManager.persist(singer);
        }else{
            log.info("Updating new singer");
            entityManager.merge(singer);
        }
        return singer;
    }

    @Override @Transactional(readOnly = false)
    public void delete(Singer singer) {
        throw new UnsupportedOperationException("");
    }

    @Override
    public List<Singer> findAllByNatvieQuery() {
        return entityManager.createNamedQuery(SQL_FINDALL,Singer.class).getResultList();
    }

    @Override
    public List<Singer> findByCriteriaQuery(String firstName, String lastName){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Singer> query = cb.createQuery(Singer.class);
        Root<Singer> singerRoot = query.from(Singer.class);

        /*select clause*/
        singerRoot.fetch(Singer_.albums,JoinType.LEFT);
        singerRoot.fetch(Singer_.instruments,JoinType.LEFT);
        query.select(singerRoot).distinct(true);

        Predicate criteria = cb.conjunction();
        if(StringUtils.hasText(firstName)){
            Predicate predicate = cb.equal(singerRoot.get(Singer_.firstName),firstName);
            criteria = cb.and(criteria,predicate);
        }
        if(StringUtils.hasText(lastName)){
            Predicate predicate = cb.equal(singerRoot.get(Singer_.lastName),lastName);
            criteria = cb.and(criteria,predicate);
        }
        return entityManager.createQuery(query.where(criteria)).getResultList();
    }
}




























