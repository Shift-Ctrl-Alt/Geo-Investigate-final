package com.oymn.geoinvestigatefinal.vo;

import com.oymn.geoinvestigatefinal.dao.pojo.DiseaseImgRecord;
import com.oymn.geoinvestigatefinal.dao.pojo.DroughtImgRecord;
import com.oymn.geoinvestigatefinal.dao.pojo.PestImgRecord;
import com.oymn.geoinvestigatefinal.dao.pojo.Record;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    
    @ApiModelProperty("病害图片链表")
    private List<DiseaseImgRecord> diseaseImgRecordList;
    
    @ApiModelProperty("虫害图片链表")
    private List<PestImgRecord> pestImgRecordList;
    
    @ApiModelProperty("干旱图片链表")
    private List<DroughtImgRecord> droughtImgRecordList;
    
    public void copyFromRecord(Record record){
        this.id = record.getId();
        this.userId = record.getUserId();
        this.surveyTime = record.getSurveyTime();
        this.lat = record.getLat();
        this.lng = record.getLng();
        this.cropType = record.getCropType();
        this.cropVariety = record.getCropVariety();
        this.diseaseType = record.getDiseaseType();
        this.diseaseSeverity = record.getDiseaseSeverity();
        this.pestType = record.getPestType();
        this.pestSeverity = record.getPestSeverity();
        this.droughtSeverity = record.getDroughtSeverity();
    }

    
}
