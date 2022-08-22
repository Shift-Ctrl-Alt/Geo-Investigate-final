package com.oymn.geoinvestigatefinal.service.impl;

import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.mapper.CropDao;
import com.oymn.geoinvestigatefinal.dao.pojo.CropType;
import com.oymn.geoinvestigatefinal.dao.pojo.CropVariety;
import com.oymn.geoinvestigatefinal.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {
    
    @Autowired
    private CropDao cropDao;

    @Override
    public Long addCropType(CropType cropType) {
        CropType dbCropType = cropDao.getCropTypeByName(cropType.getName());
        if(dbCropType != null){
            throw new ConditionException("该名称已存在");
        }
        
        cropDao.addCropType(cropType);
        return cropType.getId();
    }

    @Override
    public void updateCropType(CropType cropType) {
        cropDao.updateCropType(cropType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCropType(Long id) {
        cropDao.deleteCropVarietyByTypeId(id);
        cropDao.deleteCropType(id);
    }

    @Override
    public List<CropType> getAllCropType() {
        return cropDao.getAllCropType();
    }

    @Override
    public Long addCropVariety(CropVariety cropVariety) {
        CropType dbCropType = cropDao.getCropTypeById(cropVariety.getTypeId());
        if(dbCropType == null){
            throw new ConditionException("作物类型不存在");
        }
        
        CropVariety dbCropVariety = cropDao.getCropVariety(cropVariety.getTypeId(), cropVariety.getName());
        if(dbCropVariety != null){
            throw new ConditionException("作物品种名称已存在");
        }
        
        cropDao.addCropVariety(cropVariety);
        return cropVariety.getId();
    }

    @Override
    public void updateCropVariety(CropVariety cropVariety) {
        cropDao.updateCropVariety(cropVariety);
    }

    @Override
    public void deleteCropVariety(Long id) {
        cropDao.deleteCropVariety(id);
    }

    @Override
    public List<CropVariety> getAllCropVariety() {
        return cropDao.getAllCropVariety();
    }
}
