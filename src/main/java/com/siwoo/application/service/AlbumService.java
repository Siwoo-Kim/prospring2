package com.siwoo.application.service;

import com.siwoo.application.domain.Album;
import com.siwoo.application.domain.Singer;

import java.util.List;

public interface AlbumService {

    List<Album> findBySinger(Singer singer);

    List<Album> findByTitile(String title);
}
