package com.oymn.geoinvestigatefinal.service;

import com.oymn.geoinvestigatefinal.dao.pojo.PageResult;
import com.oymn.geoinvestigatefinal.dao.pojo.Permission;

public interface PermissionService {


    Long addPermission(Permission permission);

    void updatePermission(Permission permission);

    PageResult<Permission> pagePermission(Integer pageNo, Integer pageSize);

    Permission getPermissionById(Long permissionId);
    
    
}
