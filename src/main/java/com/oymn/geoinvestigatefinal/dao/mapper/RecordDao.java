package com.oymn.geoinvestigatefinal.dao.mapper;

import com.oymn.geoinvestigatefinal.dao.pojo.DiseaseImgRecord;
import com.oymn.geoinvestigatefinal.dao.pojo.DroughtImgRecord;
import com.oymn.geoinvestigatefinal.dao.pojo.PestImgRecord;
import com.oymn.geoinvestigatefinal.dao.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordDao {


    void addRecord(Record record);

    void updateRecord(Record record);

    void deleteRecordById(Long id);

    Record getRecordById(Long id);

    int getRecordCountByUserId(Long userId);

    List<Record> pageRecord(Map<String, Long> params);

    void addDiseaseImg(DiseaseImgRecord diseaseImgRecord);

    DiseaseImgRecord getDiseaseImgById(Long id);

    void deleteDiseaseImg(Long id);

    void addPestImg(PestImgRecord pestImgRecord);

    DiseaseImgRecord getPestImgById(Long id);

    void deletePestImg(Long id);

    void addDroughtImg(DroughtImgRecord droughtImgRecord);

    DiseaseImgRecord getDroughtImgById(Long id);

    void deleteDroughtImg(Long id);

    void deleteDiseaseImgByRecordId(Long recordId);

    void deletePestImgByRecordId(Long recordId);

    void deleteDroughtImgByRecordImg(Long recordId);

    List<DiseaseImgRecord> getDiseaseImgRecord(Long recordId);

    List<PestImgRecord> getPestImgRecord(Long recordId);

    List<DroughtImgRecord> getDroughtImgRecord(Long recordId);
    
}
