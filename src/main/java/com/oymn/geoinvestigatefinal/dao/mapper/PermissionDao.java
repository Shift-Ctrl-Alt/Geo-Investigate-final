package com.oymn.geoinvestigatefinal.dao.mapper;
import com.oymn.geoinvestigatefinal.dao.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface PermissionDao {

    Permission getPermissionByName(String name);

    void addPermission(Permission permission);

    void updatePermission(Permission permission);

    int getPermissionCount();


    List<Permission> pagePermission(Map<String, Integer> params);

    Permission getPermissionById(Long permissionId);
    
}
