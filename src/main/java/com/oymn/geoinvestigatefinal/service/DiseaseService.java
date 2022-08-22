package com.oymn.geoinvestigatefinal.service;

import com.oymn.geoinvestigatefinal.dao.pojo.DiseaseType;

import java.util.List;

public interface DiseaseService {

    /**
     * 添加病害类型
     * @param diseaseType
     * @return
     */
    Long addDiseaseType(DiseaseType diseaseType);

    /**
     * 修改病害类型
     * @param diseaseType
     */
    void updateDiseaseType(DiseaseType diseaseType);

    /**
     * 通过id删除病害类型
     * @param diseaseTypeId
     */
    void deleteDiseaseType(Long diseaseTypeId);

    /**
     * 查询所有的病害类型
     * @return
     */
    List<DiseaseType> getAllDiseaseType();
    
    
}
