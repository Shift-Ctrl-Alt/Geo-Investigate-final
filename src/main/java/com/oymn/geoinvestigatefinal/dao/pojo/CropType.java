package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("作物类型实体类")
@Data
public class CropType {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("创建用户")
    private Long createUser;

    @ApiModelProperty("是否是管理员")
    private Integer isManager;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public CropType() {
    }

    public CropType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CropType(String name, Long createUser, Integer isManager) {
        this.name = name;
        this.createUser = createUser;
        this.isManager = isManager;
    }
}
