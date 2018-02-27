package com.siwoo.application.repository;

import com.siwoo.application.domain.Album;
import com.siwoo.application.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album,Long> {

    @Query("select a from Album a where a.title like %:title%")
    List<Album> findByTilte(@Param("title") String title);

    List<Album> findBySinger(Singer singer);
}
