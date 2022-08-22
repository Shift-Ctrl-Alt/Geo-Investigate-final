package com.oymn.geoinvestigatefinal.dao.mapper;

import com.oymn.geoinvestigatefinal.dao.pojo.PestType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PestDao {

    PestType getPestTypeByName(String name);

    void addPestType(PestType pestType);

    void updatePestType(PestType pestType);

    void deletePestType(Long id);

    List<PestType> getAllPestType();
    
}
