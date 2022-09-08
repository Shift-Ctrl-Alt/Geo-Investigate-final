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
    private String nameChs;
    
    @ApiModelProperty("英文名称")
    private String nameEn;

    @ApiModelProperty("创建用户")
    private Long createUser;

    @ApiModelProperty("是否是管理员")
    private Integer isManager;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public CropVariety() {
    }

    public CropVariety(Long typeId, String name, String nameEn, Long createUser, Integer isManager) {
        this.typeId = typeId;
        this.nameChs = name;
        this.nameEn = nameEn;
        this.createUser = createUser;
        this.isManager = isManager;
    }
}
