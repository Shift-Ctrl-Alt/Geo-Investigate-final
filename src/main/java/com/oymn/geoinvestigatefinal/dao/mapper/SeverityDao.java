package com.oymn.geoinvestigatefinal.dao.mapper;

import com.oymn.geoinvestigatefinal.dao.pojo.Severity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeverityDao {

    Severity getSeverityByName(String name);

    void addSeverity(Severity severity);

    void updateSeverity(Severity severity);

    void deleteSeverity(Long id);

    List<Severity> getAllSeverity();
}
