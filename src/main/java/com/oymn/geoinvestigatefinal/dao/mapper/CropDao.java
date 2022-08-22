package com.oymn.geoinvestigatefinal.dao.mapper;

import com.oymn.geoinvestigatefinal.dao.pojo.CropType;
import com.oymn.geoinvestigatefinal.dao.pojo.CropVariety;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CropDao {

    CropType getCropTypeByName(String name);

    void addCropType(CropType cropType);

    void updateCropType(CropType cropType);

    void deleteCropType(Long id);

    List<CropType> getAllCropType();
    
    CropType getCropTypeById(Long typeId);
    
    CropVariety getCropVariety(@Param("typeId") Long typeId, @Param("cropVarietyName") String name);

    void addCropVariety(CropVariety cropVariety);

    void updateCropVariety(CropVariety cropVariety);

    void deleteCropVariety(Long id);

    List<CropVariety> getAllCropVariety();


    void deleteCropVarietyByTypeId(Long typeId);
    
}
