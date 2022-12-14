package com.oymn.geoinvestigatefinal.service.impl;

import com.oymn.geoinvestigatefinal.common.StatusCode;
import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.mapper.UserDao;
import com.oymn.geoinvestigatefinal.dao.pojo.PageResult;
import com.oymn.geoinvestigatefinal.dao.pojo.Role;
import com.oymn.geoinvestigatefinal.dao.pojo.User;
import com.oymn.geoinvestigatefinal.service.RoleService;
import com.oymn.geoinvestigatefinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private RoleService roleService;
    
    
    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public Long addUser(User user) {
        userDao.addUser(user);
        return user.getId();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserById(Long id) {
        if(id == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        userDao.deleteUserById(id);
        userDao.deleteRoleByUserId(id);
    }

    @Override
    public PageResult<User> pageUser(Integer pageNo, Integer pageSize) {
        if(pageNo == null || pageSize == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }

        Map<String, Object> params = new HashMap<>();
        params.put("start", (pageNo - 1) * pageSize);
        params.put("size", pageSize);
        
        int count = userDao.getUserCount();
        List<User> userList = userDao.getUsers(params);
        
        return new PageResult<>(count, userList);
    }

    @Override
    public void addRole(Long userId, Long roleId) {
        if(userId == null || roleId == null){
            throw new ConditionException(StatusCode.PARAMS_ERROR.getCode(), StatusCode.PARAMS_ERROR.getMsg());
        }
        
        User dbUser = userDao.getUserById(userId);
        if(dbUser == null){
            throw new ConditionException("??????????????????");
        }
        
        Role dbRole = roleService.getRoleById(roleId);
        if(dbRole == null){
            throw new ConditionException("??????????????????");
        }
        
        Long id = userHasRole(userId, roleId);
        if(id != null){
            throw new ConditionException("???????????????????????????");
        }
        
        userDao.addRole(userId, roleId);
    }

    private Long userHasRole(Long userId, Long roleId) {
        return userDao.getUserRoleByUidAndRid(userId, roleId);
    }

    @Override
    public void deleteRole(Long userId, Long roleId) {
        userDao.deleteRole(userId, roleId);
    }

    @Override
    public List<Role> getRolesByUserId(Long userId) {
        return userDao.getRolesByUserId(userId);
    }

    @Override
    public List<Role> getRolesByUsername(String username) {
        return roleService.getRoleByUsername(username);
    }
}
