package com.siwoo.application.service;

import com.google.common.collect.Lists;
import com.siwoo.application.domain.Singer;
import com.siwoo.application.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("advancedSpringServiceImpl") @Transactional(readOnly = true)
public class AdvancedSingerServiceImpl implements SingerService {

    @Autowired SingerRepository singerRepository;

    public List<Singer> findByFirstName(String firstName){
        return singerRepository.findByFirstName(firstName);
    }

    public List<Singer> findByFirstNameAndLastName(String firstName,String lastName){
        return singerRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll()); //iterable
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public Singer findById(Long id) {
        return null;
    }

    @Override @Transactional(readOnly = false)
    public Singer save(Singer singer) {
        return null;
    }

    @Override @Transactional(readOnly = false)
    public void delete(Singer singer) {

    }

    @Override
    public List<Singer> findAllByNatvieQuery() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public List<Singer> findByCriteriaQuery(String firstName, String lastName) {
        throw new UnsupportedOperationException("");
    }
}
