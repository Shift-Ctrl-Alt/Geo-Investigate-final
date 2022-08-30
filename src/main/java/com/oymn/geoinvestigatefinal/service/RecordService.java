package com.oymn.geoinvestigatefinal.service;

import com.oymn.geoinvestigatefinal.dao.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecordService {

    /**
     * 添加一条记录
     * @param record
     * @return
     */
    Long addRecord(Record record);

    /**
     * 修改记录
     * @param record
     */
    void updateRecord(Record record);

    /**
     * 根据id删除记录
     * @param id
     */
    void deleteRecord(Long id);

    /**
     * 通过id获取记录
     * @param id
     * @return
     */
    Record getRecordById(Long id);

    /**
     * 用户分页查询记录
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult<Record> pageRecord(Long userId, Long pageNo, Long pageSize);

    /**
     * 添加灾害图片
     * @param diseaseImgRecord
     * @return
     */
    Long addDiseaseImg(DiseaseImgRecord diseaseImgRecord);

    /**
     * 通过id获取病害图片
     * @param id
     * @return
     */
    DiseaseImgRecord getDiseaseImgById(Long id);

    /**
     * 删除病害图片
     * @param id
     */
    void deleteDiseaseImg(Long id);

    /**
     * 添加虫害图片
     * @param pestImgRecord
     * @return
     */
    Long addPestImg(PestImgRecord pestImgRecord);

    /**
     * 获取虫害图片
     * @param id
     * @return
     */
    DiseaseImgRecord getPestImgById(Long id);

    /**
     * 通过id删除虫害图片
     * @param id
     */
    void deletePestImg(Long id);

    /**
     * 添加干旱图片
     * @param droughtImgRecord
     * @return
     */
    Long addDroughtImg(DroughtImgRecord droughtImgRecord);

    /**
     * 获取干旱图片
     * @param id
     * @return
     */
    DiseaseImgRecord getDroughtImgById(Long id);

    /**
     * 删除干旱图片
     * @param id
     */
    void deleteDroughtImg(Long id);

    /**
     * 通过主记录获取病害图片记录
     * @param recordId
     * @return
     */
    List<DiseaseImgRecord> getDiseaseImgRecord(Long recordId);

    /**
     * 通过主记录获取虫害图片记录
     * @param recordId
     * @return
     */
    List<PestImgRecord> getPestImgRecord(Long recordId);

    /**
     * 通过主记录获取干旱图片记录
     * @param recordId
     * @return
     */
    List<DroughtImgRecord> getDroughtImgRecord(Long recordId);

    /**
     * 添加病害类型
     * @param diseaseName
     * @param currentUserId
     */
    Long addDiseaseType(DiseaseType diseaseType);

    /**
     * 添加虫害类型
     * @param pestType
     * @return
     */
    Long addPestType(PestType pestType);

    /**
     * 添加作物类型
     * @param cropType
     * @return
     */
    Long addCropType(CropType cropType);

    /**
     * 添加作物品种
     * @param cropVariety
     * @return
     */
    Long addCropVariety(CropVariety cropVariety);

    /**
     * 获取病害类型（包括下拉菜单和用户自定义）
     * @param userId
     * @return
     */
    List<DiseaseType> getAllDiseaseType(Long userId);

    /**
     * 获取虫害类型（包括下拉菜单和用户自定义）
     * @param currentUserId
     * @return
     */
    List<PestType> getAllPestType(Long currentUserId);

    /**
     * 获取作物类型（包括下拉菜单和用户自定义）
     * @param currentUserId
     * @return
     */
    List<CropType> getAllCropType(Long currentUserId);
    
}
