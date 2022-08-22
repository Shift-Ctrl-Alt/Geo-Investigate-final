package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("灾害图片实体类")
@Data
public class DroughtImgRecord {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("记录id")
    private Long recordId;

    @ApiModelProperty("url")
    private String imgUrl;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public DroughtImgRecord() {
    }

    public DroughtImgRecord(Long recordId, String imgUrl) {
        this.recordId = recordId;
        this.imgUrl = imgUrl;
    }
}
