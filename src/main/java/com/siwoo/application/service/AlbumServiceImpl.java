package com.siwoo.application.service;

import com.siwoo.application.domain.Album;
import com.siwoo.application.domain.Singer;
import com.siwoo.application.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("albumServiceImpl") @Transactional(readOnly = true)
public class AlbumServiceImpl implements AlbumService {

    @Autowired AlbumRepository albumRepository;

    @Override
    public List<Album> findBySinger(Singer singer){
        return albumRepository.findBySinger(singer);
    }

    @Override
    public List<Album> findByTitile(String title){
        return albumRepository.findByTilte(title);
    }
}
