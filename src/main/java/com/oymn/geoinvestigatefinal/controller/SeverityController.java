package com.oymn.geoinvestigatefinal.controller;

import com.oymn.geoinvestigatefinal.dao.pojo.Severity;
import com.oymn.geoinvestigatefinal.service.SeverityService;
import com.oymn.geoinvestigatefinal.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("严重程度的录入接口")
@RestController
@RequestMapping("severity")
public class SeverityController {
    
    @Autowired
    private SeverityService severityService;
    
    @ApiOperation("添加严重程度")
    @PostMapping("/add")
    @PreAuthorize("@ex.hasAuthority('system:severity:add')")
    public Result<Long> addSeverity(@ApiParam("严重程度名称") @RequestParam String name,
                                    @ApiParam("英文名称") @RequestParam String nameEn){
        Long id = severityService.addSeverity(new Severity(name, nameEn));
        return Result.success(id);
    }
    
    @ApiOperation("修改严重程度")
    @PutMapping("/update")
    @PreAuthorize("@ex.hasAuthority('system:severity:update')")
    public Result updateSeverity(@ApiParam("严重程度实体类") @RequestBody Severity severity){
        severityService.updateSeverity(severity);
        return Result.success();
    }
    
    @ApiOperation("删除严重程度")
    @DeleteMapping("/delete")
    @PreAuthorize("@ex.hasAuthority('system:severity:delete')")
    public Result deleteSeverity(@ApiParam("id") @RequestParam Long id){
        severityService.deleteSeverity(id);
        return Result.success();
    }
    
    @ApiOperation("查询所有的严重程度")
    @GetMapping("/get")
    @PreAuthorize("@ex.hasAuthority('system:severity:get')")
    public Result<List<Severity>> getAllSeverity(){
        List<Severity> severityList = severityService.getAllSeverity();
        return Result.success(severityList);
    }
    
}
