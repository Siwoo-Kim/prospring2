package com.siwoo.application.service;

import com.google.common.collect.Lists;
import com.siwoo.application.domain.Singer;
import com.siwoo.application.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("transactionSingerService") @Transactional(readOnly = true)
public class TransactionSingerService {

    @Autowired private SingerRepository singerRepository;

    public List<Singer> findAll(){
        System.out.println(singerRepository);
        return Lists.newArrayList( singerRepository.findAll() );
    }

    public Singer findById(Long id){
        return singerRepository.findById(id).get();
    }

    @Transactional(readOnly = false)
    public Singer save(Singer singer){
        return singerRepository.save(singer);
    }

    @Transactional(propagation = Propagation.NEVER)
    public long countAll(){
        return singerRepository.countAllSingers();
    }
}
