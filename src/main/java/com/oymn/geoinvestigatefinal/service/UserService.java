package com.oymn.geoinvestigatefinal.service;


import com.oymn.geoinvestigatefinal.dao.pojo.PageResult;
import com.oymn.geoinvestigatefinal.dao.pojo.Role;
import com.oymn.geoinvestigatefinal.dao.pojo.User;

import java.util.List;

public interface UserService {
    
    User getUserByName(String username);

    Long addUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    PageResult<User> pageUser(Integer pageNo, Integer pageSize);

    void addRole(Long userId, Long roleId);

    void deleteRole(Long userId, Long roleId);

    List<Role> getRolesByUserId(Long userId);
    
    List<Role> getRolesByUsername(String username);
    
}
