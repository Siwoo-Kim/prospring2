package com.siwoo.application.repository;

import com.siwoo.application.domain.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer,Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName,String lastName);
    @Query("select count(s) from Singer s")
    Long countAllSingers();
}
