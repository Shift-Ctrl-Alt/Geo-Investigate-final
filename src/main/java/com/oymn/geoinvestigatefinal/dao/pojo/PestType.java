package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("虫害类型实体类")
@Data
public class PestType {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("虫害类型名")
    private String nameChs;

    @ApiModelProperty("英文名")
    private String nameEn;
    
    @ApiModelProperty("创建用户")
    private Long createUser;
    
    @ApiModelProperty("是否是管理员")
    private Integer isManager;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public PestType() {
    }

    public PestType(Long id, String name) {
        this.id = id;
        this.nameChs = name;
    }

    public PestType(String name, String nameEn, Long createUser, Integer isManager) {
        this.nameChs = name;
        this.nameEn = nameEn;
        this.createUser = createUser;
        this.isManager = isManager;
    }
}
