package com.oymn.geoinvestigatefinal.service;

import com.oymn.geoinvestigatefinal.dao.pojo.PestType;

import java.util.List;

public interface PestService {

    /**
     * 添加虫害类型
     * @param pestType
     * @return
     */
    Long addPestType(PestType pestType);

    /**
     * 更新虫害类型
     * @param pestType
     */
    void updatePestType(PestType pestType);

    /**
     * 根据id删除虫害类型
     * @param id
     */
    void deletePestType(Long id);

    /**
     * 查询所有的虫害类型
     * @return
     */
    List<PestType> getAllPestType();
    
    
}
