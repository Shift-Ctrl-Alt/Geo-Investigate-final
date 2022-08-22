package com.oymn.geoinvestigatefinal.service.impl;

import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.mapper.PestDao;
import com.oymn.geoinvestigatefinal.dao.pojo.PestType;
import com.oymn.geoinvestigatefinal.service.PestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PestServiceImpl implements PestService {
    
    @Autowired
    private PestDao pestDao;

    @Override
    public Long addPestType(PestType pestType) {
        PestType dbPestType = pestDao.getPestTypeByName(pestType.getName());
        if(dbPestType != null){
            throw new ConditionException("该虫害类型已存在");
        }
        
        pestDao.addPestType(pestType);
        return pestType.getId();
    }

    @Override
    public void updatePestType(PestType pestType) {
        pestDao.updatePestType(pestType);
    }

    @Override
    public void deletePestType(Long id) {
        pestDao.deletePestType(id);
    }

    @Override
    public List<PestType> getAllPestType() {
        return pestDao.getAllPestType();
    }
}
