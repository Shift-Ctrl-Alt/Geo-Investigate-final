package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("土地类型 LandType")
public class LandType {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("中文名称")
    private String nameChs;

    @ApiModelProperty("英文名称")
    private String nameEn;
    
    @ApiModelProperty("父类型的id")
    private Long parentId;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("最新的更新时间")
    private Date updateTime;

    public LandType() {
    }

    public LandType(Long id, String nameChs, String nameEn, Long parentId, Date createTime, Date updateTime) {
        this.id = id;
        this.nameChs = nameChs;
        this.nameEn = nameEn;
        this.parentId = parentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameChs() {
        return nameChs;
    }

    public void setNameChs(String nameChs) {
        this.nameChs = nameChs;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
