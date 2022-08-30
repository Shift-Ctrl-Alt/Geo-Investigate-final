package com.oymn.geoinvestigatefinal.service.impl;

import com.oymn.geoinvestigatefinal.common.StatusCode;
import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.mapper.CropDao;
import com.oymn.geoinvestigatefinal.dao.mapper.RecordDao;
import com.oymn.geoinvestigatefinal.dao.pojo.*;
import com.oymn.geoinvestigatefinal.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    
    @Autowired
    private RecordDao recordDao;
    
    @Autowired
    private CropDao cropDao;

    @Override
    public Long addRecord(Record record) {
        recordDao.addRecord(record);
        return record.getId();
    }

    @Override
    public void updateRecord(Record record) {
        recordDao.updateRecord(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteRecord(Long id) {
        recordDao.deleteRecordById(id);
        recordDao.deleteDiseaseImgByRecordId(id);
        recordDao.deletePestImgByRecordId(id);
        recordDao.deleteDroughtImgByRecordImg(id);
    }

    @Override
    public Record getRecordById(Long id) {
        return recordDao.getRecordById(id);
    }

    @Override
    public PageResult<Record> pageRecord(Long userId, Long pageNo, Long pageSize) {
        if(userId == null || pageNo == null || pageSize == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        Map<String, Long> params = new HashMap<>();
        params.put("userId", userId);
        params.put("start", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        int total = recordDao.getRecordCountByUserId(userId);
        List<Record> recordList = recordDao.pageRecord(params);
        
        return new PageResult<>(total, recordList);
    }

    @Override
    public Long addDiseaseImg(DiseaseImgRecord diseaseImgRecord) {
        recordDao.addDiseaseImg(diseaseImgRecord);
        return diseaseImgRecord.getId();
    }

    @Override
    public DiseaseImgRecord getDiseaseImgById(Long id) {
        return recordDao.getDiseaseImgById(id);
    }

    @Override
    public void deleteDiseaseImg(Long id) {
        recordDao.deleteDiseaseImg(id);
    }

    @Override
    public Long addPestImg(PestImgRecord pestImgRecord) {
        recordDao.addPestImg(pestImgRecord);
        return pestImgRecord.getId();
    }

    @Override
    public DiseaseImgRecord getPestImgById(Long id) {
        return recordDao.getPestImgById(id);
    }

    @Override
    public void deletePestImg(Long id) {
        recordDao.deletePestImg(id);
    }

    @Override
    public Long addDroughtImg(DroughtImgRecord droughtImgRecord) {
        recordDao.addDroughtImg(droughtImgRecord);
        return droughtImgRecord.getId();
    }

    @Override
    public DiseaseImgRecord getDroughtImgById(Long id) {
        return recordDao.getDroughtImgById(id);
    }

    @Override
    public void deleteDroughtImg(Long id) {
        recordDao.deleteDroughtImg(id);
    }

    @Override
    public List<DiseaseImgRecord> getDiseaseImgRecord(Long recordId) {
        return recordDao.getDiseaseImgRecord(recordId);
    }

    @Override
    public List<PestImgRecord> getPestImgRecord(Long recordId) {
        return recordDao.getPestImgRecord(recordId);
    }

    @Override
    public List<DroughtImgRecord> getDroughtImgRecord(Long recordId) {
        return recordDao.getDroughtImgRecord(recordId);
    }

    @Override
    public Long addDiseaseType(DiseaseType diseaseType) {
        recordDao.addDiseaseType(diseaseType);
        return diseaseType.getId();
    }

    @Override
    public Long addPestType(PestType pestType) {
        recordDao.addPestType(pestType);
        return pestType.getId();
    }

    @Override
    public Long addCropType(CropType cropType) {
        recordDao.addCropType(cropType);
        return cropType.getId();
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
    public List<DiseaseType> getAllDiseaseType(Long userId) {
        return recordDao.getAllDiseaseType(userId);
    }

    @Override
    public List<PestType> getAllPestType(Long userId) {
        return recordDao.getAllPestType(userId);
    }

    @Override
    public List<CropType> getAllCropType(Long userId) {
        return recordDao.getAllCropType(userId);
    }

    @Override
    public List<CropVariety> getCropVariety(Long cropTypeId, Long userId) {
        return recordDao.getCropVariety(cropTypeId, userId);
    }
}
