package com.oymn.geoinvestigatefinal.dao.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel("记录的相关接口")
@Data
public class Record {
    
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
    private Long cropType;
    
    @ApiModelProperty("作物品种")
    private Long cropVariety;
    
    @ApiModelProperty("病害类型")
    private Long diseaseType;
    
    @ApiModelProperty("病害的严重程度")
    private Long diseaseSeverity;
    
    @ApiModelProperty("虫害类型")
    private Long pestType;
    
    @ApiModelProperty("虫害的严重程度")
    private Long pestSeverity;
    
    @ApiModelProperty("干旱的严重程度")
    private Long droughtSeverity;
    
    @ApiModelProperty("土地信息")
    private String landMsg;
    
    @ApiModelProperty("创建时间")
    private Date createTime;
    
    @ApiModelProperty("修改时间")
    private Date updateTime;

    public Record() {
    }

    public Record(Long userId, Long surveyTime, Double lat, Double lng, Long cropType, Long cropVariety, Long diseaseType, Long diseaseSeverity, Long pestType, Long pestSeverity, Long droughtSeverity, String landMsg) {
        this.userId = userId;
        this.surveyTime = surveyTime;
        this.lat = lat;
        this.lng = lng;
        this.cropType = cropType;
        this.cropVariety = cropVariety;
        this.diseaseType = diseaseType;
        this.diseaseSeverity = diseaseSeverity;
        this.pestType = pestType;
        this.pestSeverity = pestSeverity;
        this.droughtSeverity = droughtSeverity;
        this.landMsg = landMsg;
    }
}
