package com.oymn.geoinvestigatefinal.controller;

import com.oymn.geoinvestigatefinal.dao.pojo.PestType;
import com.oymn.geoinvestigatefinal.dao.pojo.User;
import com.oymn.geoinvestigatefinal.handler.UserSupport;
import com.oymn.geoinvestigatefinal.service.PestService;
import com.oymn.geoinvestigatefinal.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("虫害的相关接口")
@RestController
@RequestMapping("pest")
public class PestController {
    
    @Autowired
    private PestService pestService;
    
    @Autowired
    private UserSupport userSupport;
    
    @ApiOperation("添加虫害类型")
    @PostMapping("/add")
    @PreAuthorize("@ex.hasAuthority('system:pest:add')")
    public Result<Long> addPestType(@ApiParam("虫害类型的名称") @RequestParam String name,
                                    @ApiParam("英文名称") @RequestParam String nameEn){
        Long id = pestService.addPestType(new PestType(name,nameEn, userSupport.getCurrentUserId(), 1));
        return Result.success(id);
    }
    
    @ApiOperation("修改虫害类型")
    @PutMapping("/update")
    @PreAuthorize("@ex.hasAuthority('system:pest:update')")
    public Result updatePestType(@ApiParam("虫害类型实体类") @RequestBody PestType pestType){
        pestService.updatePestType(pestType);
        return Result.success();
    }
    
    @ApiOperation("删除虫害类型")
    @DeleteMapping("/delete")
    @PreAuthorize("@ex.hasAuthority('system:pest:delete')")
    public Result deletePestType(@ApiParam("虫害类型的id") @RequestParam Long id){
        pestService.deletePestType(id);
        return Result.success();
    }
    
    @ApiOperation("获取所有的虫害类型")
    @GetMapping("/get")
    @PreAuthorize("@ex.hasAuthority('system:pest:get')")
    public Result<List<PestType>> getAllPestType(){
        List<PestType> pestTypeList = pestService.getAllPestType();
        return Result.success(pestTypeList);
    }
}
