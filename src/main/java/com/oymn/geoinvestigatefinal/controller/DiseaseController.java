package com.oymn.geoinvestigatefinal.controller;

import com.oymn.geoinvestigatefinal.dao.pojo.DiseaseType;
import com.oymn.geoinvestigatefinal.handler.UserSupport;
import com.oymn.geoinvestigatefinal.service.DiseaseService;
import com.oymn.geoinvestigatefinal.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("病害相关的接口")
@RestController
@RequestMapping("disease")
public class DiseaseController {
    
    @Autowired
    private DiseaseService diseaseService;
    
    @Autowired
    private UserSupport userSupport;
    
    @ApiOperation("添加病害类型")
    @PostMapping("/add")
    @PreAuthorize("@ex.hasAuthority('system:disease:add')")
    public Result<Long> addDiseaseType(@ApiParam("病害类型名称") @RequestParam String nameChs,
                                       @ApiParam("英文名称") @RequestParam String nameEn){
        Long id = diseaseService.addDiseaseType(new DiseaseType(nameChs, nameEn, userSupport.getCurrentUserId(), 1));
        return Result.success(id);
    }
    
    @ApiOperation("修改病害类型")
    @PutMapping("/update")
    @PreAuthorize("@ex.hasAuthority('system:disease:update')")
    public Result updateDiseaseType(@ApiParam("病害类型实体类") @RequestBody DiseaseType diseaseType){
        diseaseService.updateDiseaseType(diseaseType);
        return Result.success();
    }
    
    @ApiOperation("删除病害类型")
    @DeleteMapping("/delete")
    @PreAuthorize("@ex.hasAuthority('system:disease:delete')")
    public Result deleteDiseaseType(@ApiParam("病害类型的id") @RequestParam Long diseaseTypeId){
        diseaseService.deleteDiseaseType(diseaseTypeId);
        return Result.success();
    }
    
    @ApiOperation("查询所有的病害类型")
    @GetMapping("/get")
    @PreAuthorize("@ex.hasAuthority('system:disease:get')")
    public Result<List<DiseaseType>> getAllDiseaseType(){
        List<DiseaseType> diseaseTypeList = diseaseService.getAllDiseaseType();
        return Result.success(diseaseTypeList);
    }
}
