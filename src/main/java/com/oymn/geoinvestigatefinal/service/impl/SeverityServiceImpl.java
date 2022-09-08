package com.oymn.geoinvestigatefinal.service.impl;

import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.mapper.SeverityDao;
import com.oymn.geoinvestigatefinal.dao.pojo.Severity;
import com.oymn.geoinvestigatefinal.service.SeverityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeverityServiceImpl implements SeverityService {
    
    @Autowired
    private SeverityDao severityDao;

    @Override
    public Long addSeverity(Severity severity) {
        Severity dbSeverity = severityDao.getSeverityByName(severity.getNameChs());
        if(dbSeverity != null){
            throw new ConditionException("该名称已存在");
        }
        
        severityDao.addSeverity(severity);
        return severity.getId();
    }

    @Override
    public void updateSeverity(Severity severity) {
        severityDao.updateSeverity(severity);
    }

    @Override
    public void deleteSeverity(Long id) {
        severityDao.deleteSeverity(id);
    }

    @Override
    public List<Severity> getAllSeverity() {
        return severityDao.getAllSeverity();
    }
}
