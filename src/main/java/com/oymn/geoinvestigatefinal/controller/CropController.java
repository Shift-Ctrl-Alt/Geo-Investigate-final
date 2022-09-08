package com.oymn.geoinvestigatefinal.controller;

import com.oymn.geoinvestigatefinal.dao.pojo.CropType;
import com.oymn.geoinvestigatefinal.dao.pojo.CropVariety;
import com.oymn.geoinvestigatefinal.handler.UserSupport;
import com.oymn.geoinvestigatefinal.service.CropService;
import com.oymn.geoinvestigatefinal.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation("和作物相关的接口")
@RestController
@RequestMapping("crop")
public class CropController {
    
    @Autowired
    private CropService cropService;
    
    @Autowired
    private UserSupport userSupport;
    
    @ApiOperation("添加作物类型")
    @PostMapping("add-type")
    @PreAuthorize("@ex.hasAuthority('system:crop:addtype')")
    public Result<Long> addCropType(@ApiParam("作物类型名称") @RequestParam String nameChs, 
                                    @ApiParam("英文名称") @RequestParam String nameEn){
        Long id = cropService.addCropType(new CropType(nameChs, nameEn, userSupport.getCurrentUserId(), 1));
        return Result.success(id);
    }
    
    @ApiOperation("修改作物类型")
    @PutMapping("update-type")
    @PreAuthorize("@ex.hasAuthority('system:crop:updatetype')")
    public Result updateCropType(@ApiParam("作物类型实体类") @RequestBody CropType cropType){
        cropService.updateCropType(cropType);
        return Result.success();
    }
    
    @ApiOperation("删除作物类型")
    @DeleteMapping("delete-type")
    @PreAuthorize("@ex.hasAuthority('system:crop:deletetype')")
    public Result deleteCropType(@ApiParam("id") @RequestParam Long id){
        cropService.deleteCropType(id);
        return Result.success();
    }
    
    @ApiOperation("查询所有的作物类型")
    @GetMapping("get-type")
    @PreAuthorize("@ex.hasAuthority('system:crop:gettype')")
    public Result<List<CropType>> getAllCropType(){
        List<CropType> cropTypeList = cropService.getAllCropType();
        return Result.success(cropTypeList);
    }
    
    @ApiOperation("添加作物品种")   
    @PostMapping("add-variety")
    @PreAuthorize("@ex.hasAuthority('system:crop:addvariety')")
    public Result<Long> addCropVariety(@ApiParam("作物类型的id") @RequestParam Long cropTypeId,
                                       @ApiParam("作物品种的名称") @RequestParam String nameChs,
                                       @ApiParam("英文名称") @RequestParam String nameEn){
        Long id = cropService.addCropVariety(new CropVariety(cropTypeId, nameChs, nameEn, userSupport.getCurrentUserId(), 1));
        return Result.success(id);
    }
    
    @ApiOperation("修改作物品种")
    @PutMapping("update-variety")
    @PreAuthorize("@ex.hasAuthority('system:crop:updatevariety')")
    public Result updateCropVariety(@ApiParam("作物品种实体类") @RequestBody CropVariety cropVariety){
        cropService.updateCropVariety(cropVariety);
        return Result.success();
    }
    
    @ApiOperation("删除作物品种")
    @DeleteMapping("delete-variety")
    @PreAuthorize("@ex.hasAuthority('system:crop:deletevariety')")
    public Result deleteCropVariety(@ApiParam("作物品种的id") @RequestParam Long id){
        cropService.deleteCropVariety(id);
        return Result.success();
    }
    
    @ApiOperation("查询所有的作物品种")
    @GetMapping("get-variety")
    @PreAuthorize("@ex.hasAuthority('system:crop:getvariety')")
    public Result<List<CropVariety>> getAllCropVariety(){
        List<CropVariety> cropVarietyList = cropService.getAllCropVariety();
        return Result.success(cropVarietyList);
    }
}
