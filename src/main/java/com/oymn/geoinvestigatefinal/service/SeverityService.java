package com.oymn.geoinvestigatefinal.service;

import com.oymn.geoinvestigatefinal.dao.pojo.Severity;

import java.util.List;

public interface SeverityService {
    /**
     * 添加严重程度
     * @param severity
     * @return
     */
    Long addSeverity(Severity severity);

    /**
     * 修改严重程度
     * @param severity
     */
    void updateSeverity(Severity severity);

    /**
     * 删除严重程度
     * @param id
     */
    void deleteSeverity(Long id);

    /**
     * 查询所有的严重程度
     * @return
     */
    List<Severity> getAllSeverity();
    
    
}
