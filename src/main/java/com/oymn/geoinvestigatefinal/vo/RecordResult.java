package com.oymn.geoinvestigatefinal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel("记录实体类，只包含id，经纬度")
@Data
public class RecordResult {

    @ApiModelProperty("主键id")
    private Long id;

    @ApiModelProperty("经度")
    private Double lat;

    @ApiModelProperty("纬度")
    private Double lng;

    @ApiModelProperty("调查时间")
    private Long surveyTime;
}
