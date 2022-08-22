package com.oymn.geoinvestigatefinal.dao.mapper;

import com.oymn.geoinvestigatefinal.dao.pojo.DiseaseType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiseaseDao {


    void addDiseaseType(DiseaseType diseaseType);

    void updateDiseaseType(DiseaseType diseaseType);

    void deleteDiseaseType(Long diseaseTypeId);

    List<DiseaseType> getAllDiseaseType();


    DiseaseType getDiseaseTypeByName(String name);
}
