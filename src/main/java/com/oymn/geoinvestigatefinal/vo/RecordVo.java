package com.oymn.geoinvestigatefinal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("记录实体类，和Record区别是它含有图片链表")
@Data
public class RecordVo {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("调查时间")
    private Long surveyTime;

    @ApiModelProperty("经度")
    private Double lat;

    @ApiModelProperty("纬度")
    private Double lng;

    @ApiModelProperty("作物类型")
    private String cropType;

    @ApiModelProperty("作物品种")
    private String cropVariety;

    @ApiModelProperty("病害类型")
    private String diseaseType;

    @ApiModelProperty("病害的严重程度")
    private String diseaseSeverity;

    @ApiModelProperty("虫害类型")
    private String pestType;

    @ApiModelProperty("虫害的严重程度")
    private String pestSeverity;

    @ApiModelProperty("干旱的严重程度")
    private String droughtSeverity;

    
}
