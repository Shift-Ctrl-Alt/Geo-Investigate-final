package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("严重程度实体类")
@Data
public class Severity {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("英文名称")
    private String nameEn;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public Severity() {
    }

    public Severity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Severity(String name, String nameEn) {
        this.name = name;
        this.nameEn = nameEn;
    }
}
