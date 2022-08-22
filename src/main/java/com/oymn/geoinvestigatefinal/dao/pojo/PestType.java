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
    private String name;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public PestType() {
    }

    public PestType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PestType(String name) {
        this.name = name;
    }
}
