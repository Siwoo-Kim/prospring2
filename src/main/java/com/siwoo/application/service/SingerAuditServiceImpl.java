package com.siwoo.application.service;

import com.google.common.collect.Lists;
import com.siwoo.application.domain.SingerAudit;
import com.siwoo.application.repository.SingerAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("singerAuditService") @Transactional(readOnly = true)
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired SingerAuditRepository singerAuditRepository;
    @Override
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    @Override
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).get();
    }

    @Override
    public SingerAudit save(SingerAudit singerAudit) {
        return singerAuditRepository.save(singerAudit);
    }
}
