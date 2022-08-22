package com.oymn.geoinvestigatefinal.service;

import com.oymn.geoinvestigatefinal.dao.pojo.CropType;
import com.oymn.geoinvestigatefinal.dao.pojo.CropVariety;

import java.util.List;

public interface CropService {

    /**
     * 添加作物类型
     * @param cropType
     * @return
     */
    Long addCropType(CropType cropType);

    /**
     * 更新作物类型
     * @param cropType
     */
    void updateCropType(CropType cropType);

    /**
     * 删除作物类型
     * @param id
     */
    void deleteCropType(Long id);

    /**
     * 查询所有的作物类型
     * @return
     */
    List<CropType> getAllCropType();

    /**
     * 添加作物品种
     * @param cropVariety
     * @return
     */
    Long addCropVariety(CropVariety cropVariety);

    /**
     * 更新作物品种
     * @param cropVariety
     */
    void updateCropVariety(CropVariety cropVariety);

    /**
     * 删除作物品种
     * @param id
     */
    void deleteCropVariety(Long id);

    /**
     * 查询所有的作物品种
     * @return
     */
    List<CropVariety> getAllCropVariety();
    
    
}
