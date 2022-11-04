package com.oymn.geoinvestigatefinal.controller;


import com.oymn.geoinvestigatefinal.dao.pojo.LandAttribute;
import com.oymn.geoinvestigatefinal.dao.pojo.LandAttributeValue;
import com.oymn.geoinvestigatefinal.dao.pojo.LandType;
import com.oymn.geoinvestigatefinal.service.LandService;
import com.oymn.geoinvestigatefinal.vo.LandAttributeValueVo;
import com.oymn.geoinvestigatefinal.vo.LandTypeVo;
import com.oymn.geoinvestigatefinal.vo.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api("和土地相关的接口,这是管理员方的")
public class LandController {

    @Autowired
    private LandService landService;

    /**
     * 获取土地类型
     *
     * @return
     */
    @ApiOperation("获取土地类型")
    @GetMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('system:landtype:get')")
    public Result<List<LandTypeVo>> getLandType() {
        List<LandTypeVo> landTypeList = landService.getLandType(2);
        return Result.success(landTypeList);
    }

    /**
     * 获取土地属性及属性值
     *
     * @param landTypeId
     * @return
     */
    @ApiOperation("获取土地属性及属性值")
    @GetMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('system:landattribute:get')")
    public Result<List<LandAttributeValueVo>> getLandAttribute(@ApiParam("土地类型id") @RequestParam Long landTypeId) {
        List<LandAttributeValueVo> landAttributeList = landService.getLandAttribute(landTypeId, 2);
        return Result.success(landAttributeList);
    }

    /**
     * 添加土地类型
     *
     * @param landType
     * @return
     */
    @ApiOperation("添加土地类型")
    @PostMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('system:landtype:add')")
    public Result<Long> addLandType(@ApiParam("土地类型") @RequestBody LandType landType) {
        Long id = landService.addLandType(landType);
        return Result.success(id);
    }

    /**
     * 添加土地属性
     *
     * @param landAttribute
     * @return
     */
    @ApiOperation("添加土地属性")
    @PostMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('system:landattribute:add')")
    public Result<Long> addLandAttribute(@ApiParam("土地属性包装类") @RequestBody LandAttribute landAttribute) {
        Long id = landService.addLandAttribute(landAttribute);
        return Result.success(id);
    }

    /**
     * 添加土地属性值
     *
     * @param attrValues
     * @return
     */
    @ApiOperation("添加土地属性值")
    @PostMapping("land-attribute-value")
    @PreAuthorize("@ex.hasAuthority('system:landattributevalue:add')")
    public Result addLandAttrValue(@ApiParam("土地属性值的包装类") @RequestBody LandAttributeValueVo attrValues) {
        landService.addLandAttrValue(attrValues);
        return Result.success();
    }

    /**
     * 修改土地类型
     *
     * @param landType
     * @return
     */
    @ApiOperation("修改土地类型")
    @PutMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('system:landtype:update')")
    public Result updateLandType(@ApiParam("土地类型") @RequestBody LandType landType) {
        landService.updateLandType(landType);
        return Result.success();
    }

    /**
     * 删除土地类型
     *
     * @param landTypeId
     * @return
     */
    @ApiOperation("删除土地类型")
    @DeleteMapping("land-type")
    @PreAuthorize("@ex.hasAuthority('system:landtype:delete')")
    public Result deleteLandType(@ApiParam("土地类型的id") @RequestParam Integer landTypeId) {
        landService.deleteLandType(landTypeId);
        return Result.success();
    }

    @ApiOperation("修改土地属性")
    @PutMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('system:landattribute:update')")
    public Result updateLandAttribute(@ApiParam("土地属性包装类") @RequestBody LandAttribute landAttribute) {
        landService.updateLandAttribute(landAttribute);
        return Result.success();
    }

    @ApiOperation("修改土地属性值")
    @PutMapping("land-attribute-value")
    @PreAuthorize("@ex.hasAuthority('system:landattributevalue:update')")
    public Result updateLandAttrValue(@ApiParam("土地属性值类") @RequestBody LandAttributeValue landAttributeValue) {
        landService.updateLandAttrValue(landAttributeValue);
        return Result.success();
    }

    @ApiOperation("删除土地属性")
    @DeleteMapping("land-attribute")
    @PreAuthorize("@ex.hasAuthority('system:landattribute:delete')")
    public Result deleteLandAttribute(@ApiParam("土地属性的id") @RequestParam Long landAttrId) {
        landService.deleteLandAttribute(landAttrId);
        return Result.success();
    }

    @ApiOperation("删除土地属性值")
    @DeleteMapping("land-attribute-value")
    @PreAuthorize("@ex.hasAuthority('system:landattributevalue:delete')")
    public Result deleteLandAttrValue(@ApiParam("土地属性值的id") @RequestParam Long landAttrValueId) {
        landService.deleteLandAttrValue(landAttrValueId);
        return Result.success();
    }


}
