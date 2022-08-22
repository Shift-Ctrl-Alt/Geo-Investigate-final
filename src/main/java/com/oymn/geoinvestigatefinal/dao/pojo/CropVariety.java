package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("作物品种实体类")
@Data
public class CropVariety {
    @ApiModelProperty("主键id")
    private Long id;
    
    @ApiModelProperty("作物类型id")
    private Long typeId;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public CropVariety() {
    }

    public CropVariety(Long typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }
}
