package com.oymn.geoinvestigatefinal.controller;

import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.pojo.*;
import com.oymn.geoinvestigatefinal.handler.UserSupport;
import com.oymn.geoinvestigatefinal.service.FileService;
import com.oymn.geoinvestigatefinal.service.RecordService;
import com.oymn.geoinvestigatefinal.service.UserService;
import com.oymn.geoinvestigatefinal.util.Base64ToMultipartFile;
import com.oymn.geoinvestigatefinal.vo.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("记录的相关接口")
@RestController
@RequestMapping("record")
public class RecordController {
    
    @Autowired
    private RecordService recordService;
    
    @Autowired
    private UserSupport userSupport;

    @Autowired
    private FileService fileService;

    /**
     * 添加图片
     *
     * @param uploadImg 上传的图片
     * @param request   请求
     * @return 该图片的访问地址
     */
    @ApiOperation("上传图片的方法")
    @PostMapping("img")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uploadImg", paramType = "form", value = "uploadImg", dataType = "file", required = true),
            @ApiImplicitParam(name = "dir", value = "dir", dataTypeClass = String.class, required = true)
    })
    public Result uploadFile(@RequestPart("file") @RequestParam(value = "file", required = true) MultipartFile uploadImg,
                             String dir,
                             HttpServletRequest request) {
        String imgPath = fileService.uploadFile(uploadImg, dir, request);
        return Result.success(imgPath);
    }
    
    @ApiOperation("上传图片的方法：Base64")
    @PostMapping("img_base64")
    public Result uploadImg(@ApiParam("图片类") @RequestBody Img img, HttpServletRequest request){
        String imgPath = fileService.uploadFile(Base64ToMultipartFile.base64Convert(img.getImgBase64()), img.getUrl(), request);
        return Result.success(imgPath);
    }
    
    
    @ApiOperation("用户：添加一条记录")
    @PostMapping("add")
    public Result<Long> addRecord(@ApiParam("记录的实体类") @RequestBody Record record){
        Long userId = userSupport.getCurrentUserId();
        record.setUserId(userId);
        Long id = recordService.addRecord(record);
        return Result.success(id);
    }
    
    @ApiOperation("用户：修改记录")
    @PutMapping("update")
    public Result updateRecord(@ApiParam("记录的实体类") @RequestBody Record record){
        Long userId = userSupport.getCurrentUserId();
        Record dbRecord = recordService.getRecordById(record.getId());
        if(dbRecord.getUserId() != userId){
            throw new ConditionException("该记录不属于该用户");
        }
        recordService.updateRecord(record);
        return Result.success();
    }
    
    @ApiOperation("用户：删除记录")
    @DeleteMapping("delete")
    public Result deleteRecord(@ApiParam("记录的id") @RequestParam Long id){
        Long userId = userSupport.getCurrentUserId();
        Record dbRecord = recordService.getRecordById(id);
        if(dbRecord == null){
            throw new ConditionException("该记录不存在");
        }
        if(dbRecord.getUserId() != userId){
            throw new ConditionException("该记录不属于该用户");
        }
        recordService.deleteRecord(id);
        return Result.success();
    }
    
    @ApiOperation("用户：分页查询记录")
    @GetMapping("page-get")
    public Result<PageResult<Record>> pageRecord(@ApiParam("页号") @RequestParam Long pageNo,
                                               @ApiParam("页的大小") @RequestParam Long pageSize){
        Long userId = userSupport.getCurrentUserId();
        PageResult<Record> recordList = recordService.pageRecord(userId, pageNo, pageSize);
        return Result.success(recordList);
    }
    
    @ApiOperation("用户：添加病害图片")
    @PostMapping("add/disease/img")
    public Result<Long> addDiseaseImg(@ApiParam("病害记录") @RequestBody DiseaseImgRecord diseaseImgRecord){
        Long recordId = diseaseImgRecord.getRecordId();
        Record dbRecord = recordService.getRecordById(recordId);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }
        
        Long id = recordService.addDiseaseImg(diseaseImgRecord);
        return Result.success(id);
    }
    
    @ApiOperation("用户：删除病害图片")
    @DeleteMapping("delete/disease/img")
    public Result deleteDiseaseImg(@ApiParam("灾害图片的id") @RequestParam Long id){
        DiseaseImgRecord diseaseImgRecord = recordService.getDiseaseImgById(id);
        Record dbRecord = recordService.getRecordById(diseaseImgRecord.getRecordId());
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }
        
        recordService.deleteDiseaseImg(id);
        return Result.success();
    }
    
    @ApiOperation("用户：获取病害图片")
    @GetMapping("get/disease/img")
    public Result<List<DiseaseImgRecord>> getDiseaseImgRecord(@ApiParam("主记录的id") @RequestParam Long recordId){
        Record dbRecord = recordService.getRecordById(recordId);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }
        
        List<DiseaseImgRecord> diseaseImgRecordList = recordService.getDiseaseImgRecord(recordId);
        return Result.success(diseaseImgRecordList);
    }
    

    @ApiOperation("用户：添加虫害图片")
    @PostMapping("add/pest/img")
    public Result<Long> addPestImg(@ApiParam("虫害记录") @RequestBody PestImgRecord pestImgRecord){
        Long recordId = pestImgRecord.getRecordId();
        Record dbRecord = recordService.getRecordById(recordId);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        Long id = recordService.addPestImg(pestImgRecord);
        return Result.success(id);
    }

    @ApiOperation("用户：删除虫害图片")
    @DeleteMapping("delete/pest/img")
    public Result deletePestImg(@ApiParam("虫害图片的id") @RequestParam Long id){
        DiseaseImgRecord diseaseImgRecord = recordService.getPestImgById(id);
        Record dbRecord = recordService.getRecordById(diseaseImgRecord.getRecordId());
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        recordService.deletePestImg(id);
        return Result.success();
    }

    @ApiOperation("用户：获取虫害图片")
    @GetMapping("get/pest/img")
    public Result<List<PestImgRecord>> getPestImgRecord(@ApiParam("主记录的id") @RequestParam Long recordId){
        Record dbRecord = recordService.getRecordById(recordId);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        List<PestImgRecord> pestImgRecordList = recordService.getPestImgRecord(recordId);
        return Result.success(pestImgRecordList);
    }

    @ApiOperation("用户：添加干旱图片")
    @PostMapping("add/drought/img")
    public Result<Long> addDroughtImg(@ApiParam("干旱记录实体类") @RequestBody DroughtImgRecord droughtImgRecord){
        Long recordId = droughtImgRecord.getRecordId();
        Record dbRecord = recordService.getRecordById(recordId);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        Long id = recordService.addDroughtImg(droughtImgRecord);
        return Result.success(id);
    }

    @ApiOperation("用户：删除干旱图片")
    @DeleteMapping("delete/drought/img")
    public Result deleteDroughtImg(@ApiParam("干旱图片的id") @RequestParam Long id){
        DiseaseImgRecord diseaseImgRecord = recordService.getDroughtImgById(id);
        Record dbRecord = recordService.getRecordById(diseaseImgRecord.getRecordId());
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        recordService.deleteDroughtImg(id);
        return Result.success();
    }
    
    @ApiOperation("用户：获取干旱图片")
    @GetMapping("get/drought/img")
    public Result<List<DroughtImgRecord>> getDroughtImgRecord(@ApiParam("主记录的id") @RequestParam Long recordId){
        Record dbRecord = recordService.getRecordById(recordId);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        List<DroughtImgRecord> droughtImgRecordList = recordService.getDroughtImgRecord(recordId);
        return Result.success(droughtImgRecordList);
    }
    
    @ApiOperation("用户：查询单条记录")
    @GetMapping("get")
    public Result<RecordVo> getRecordById(@ApiParam("主记录的id") @RequestParam Long id){
        Record dbRecord = recordService.getRecordById(id);
        Long userId = userSupport.getCurrentUserId();
        if(userId != dbRecord.getUserId()){
            throw new ConditionException("该记录不属于该用户");
        }

        RecordVo recordVo = new RecordVo();
        recordVo.copyFromRecord(dbRecord);

        List<DiseaseImgRecord> diseaseImgRecordList = recordService.getDiseaseImgRecord(id);
        recordVo.setDiseaseImgRecordList(diseaseImgRecordList);

        List<PestImgRecord> pestImgRecordList = recordService.getPestImgRecord(id);
        recordVo.setPestImgRecordList(pestImgRecordList);

        List<DroughtImgRecord> droughtImgRecordList = recordService.getDroughtImgRecord(id);
        recordVo.setDroughtImgRecordList(droughtImgRecordList);

        return Result.success(recordVo);
    }
    
    @ApiOperation("用户：添加病害类型")
    @PostMapping("add/disease/type")
    public Result<Long> addDiseaseType(@ApiParam("病害类型的名称") @RequestParam String diseaseName){
        Long id = recordService.addDiseaseType(new DiseaseType(diseaseName, diseaseName, userSupport.getCurrentUserId(), 0));
        return Result.success(id);
    }

    @ApiOperation("用户：添加虫害类型")
    @PostMapping("add/pest/type")
    public Result<Long> addPestType(@ApiParam("虫害类型的名称") @RequestParam String pestName){
        Long id = recordService.addPestType(new PestType(pestName, pestName, userSupport.getCurrentUserId(), 0));
        return Result.success(id);
    } 
    
    @ApiOperation("用户：添加作物类型")
    @PostMapping("add/crop/type")
    public Result<Long> addCropType(@ApiParam("作物类型的名称") @RequestParam String cropTypeName){
        Long id = recordService.addCropType(new CropType(cropTypeName, cropTypeName, userSupport.getCurrentUserId(), 0));
        return Result.success(id);
    }
    
    @ApiOperation("用户：添加作物品种")
    @PostMapping("add/crop/variety")
    public Result<Long> addCropVariety(@ApiParam("作物类型的id") @RequestParam Long cropTypeId,
                                       @ApiParam("作物品种的名称") @RequestParam String name){
        Long id = recordService.addCropVariety(new CropVariety(cropTypeId, name, name, userSupport.getCurrentUserId(), 0));
        return Result.success(id);
    }

    @ApiOperation("用户：查询所有的病害类型")
    @GetMapping("/get/disease/type")
    public Result<List<DiseaseType>> getAllDiseaseType(){
        List<DiseaseType> diseaseTypeList = recordService.getAllDiseaseType(userSupport.getCurrentUserId());
        return Result.success(diseaseTypeList);
    }

    @ApiOperation("用户：查询所有的虫害类型")
    @GetMapping("/get/pest/type")
    public Result<List<PestType>> getAllPestType(){
        List<PestType> pestTypeList = recordService.getAllPestType(userSupport.getCurrentUserId());
        return Result.success(pestTypeList);
    }

    @ApiOperation("用户：查询所有的作物类型")
    @GetMapping("/get/crop/type")
    public Result<List<CropType>> getAllCropType(){
        List<CropType> cropTypeList = recordService.getAllCropType(userSupport.getCurrentUserId());
        return Result.success(cropTypeList);
    }
    
    @ApiOperation("用户：通过作物类型查询作物品种")
    @GetMapping("/get/crop/variety")
    public Result<List<CropVariety>> getCropVariety(@ApiParam("作物类型id") @RequestParam Long cropTypeId){
        List<CropVariety> cropVarietyList = recordService.getCropVariety(cropTypeId, userSupport.getCurrentUserId());
        return Result.success(cropVarietyList);
    }

    @ApiOperation("用户：获取土地类型")
    @GetMapping("/get/land/type")
    public Result<List<LandTypeVo>> getLandType(){
        List<LandTypeVo> landTypeList = recordService.getLandType();
        return Result.success(landTypeList);
    }

    /**
     * 获取土地属性及属性值
     * @param landTypeId
     * @return
     */
    @ApiOperation("用户：获取土地属性及属性值")
    @GetMapping("/get/land/attribute")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "landTypeId", value = "二级土地类型id",dataType = "Long", required = true)
    )
    public Result<List<LandAttributeValueVo>> getLandAttribute(Long landTypeId){
        List<LandAttributeValueVo> landAttributeList = recordService.getLandAttribute(landTypeId);
        return Result.success(landAttributeList);
    }

    @ApiOperation("用户：查询所有的严重程度")
    @GetMapping("/get/severity")
    public Result<List<Severity>> getAllSeverity(){
        List<Severity> severityList = recordService.getAllSeverity();
        return Result.success(severityList);
    }
    
}
