package com.oymn.geoinvestigatefinal.service.impl;

import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.mapper.DiseaseDao;
import com.oymn.geoinvestigatefinal.dao.pojo.DiseaseType;
import com.oymn.geoinvestigatefinal.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseDao diseaseDao;
    
    @Override
    public Long addDiseaseType(DiseaseType diseaseType) {
        DiseaseType dbDiseaseType = diseaseDao.getDiseaseTypeByName(diseaseType.getName());
        if(dbDiseaseType != null){
            throw new ConditionException("该病害类型已存在");
        }
        diseaseDao.addDiseaseType(diseaseType);
        return diseaseType.getId();
    }

    @Override
    public void updateDiseaseType(DiseaseType diseaseType) {
        diseaseDao.updateDiseaseType(diseaseType);
    }

    @Override
    public void deleteDiseaseType(Long diseaseTypeId) {
        diseaseDao.deleteDiseaseType(diseaseTypeId);
    }

    @Override
    public List<DiseaseType> getAllDiseaseType() {
        return diseaseDao.getAllDiseaseType();
    }
}
