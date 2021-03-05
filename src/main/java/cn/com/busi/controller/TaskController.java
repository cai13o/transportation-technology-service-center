package cn.com.busi.controller;

import cn.com.busi.domain.*;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TEmpService;
import cn.com.busi.service.TSubtaskService;
import cn.com.busi.service.TTaskService;
import com.alibaba.fastjson.JSONObject;
import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

@Api(tags = "任务管理")
@RestController
@RequestMapping("task")
public class TaskController {

    @Resource
    private TTaskService tTaskService;

    @Resource
    private TSubtaskService tSubtaskService;

    @Resource
    private TEmpService tEmpService;

    @PostMapping("saveTask")
    public Result insertSelective(@RequestBody JSONObject json) {
        TTask tTask = json.toJavaObject(TTask.class);
        System.out.println(tTask);
        if (this.tTaskService.insertSelective(tTask) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.BAD_SQL_GRAMMER);
    }

    @GetMapping("findByAllName")
    public Object findByAll() {
        List<TEmp> tEmps = this.tEmpService.findByAll(new TEmp());
        List names = new ArrayList();
        for (TEmp tEmp:tEmps) {
            names.add(tEmp.getName());
        }
        return Result.ok(ResultCodeEnum.SUCCESS, names);
    }

    @ApiOperation("添加附件")
    @RequestMapping(value = "/accessory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result sendMessage(@RequestParam("fileUpload") MultipartFile[] fileUpload) {
        System.out.println(fileUpload.length);
        String format = String.valueOf(new Date().getTime());
        List<Object> list = new ArrayList<>();
        for (MultipartFile multipartFile : fileUpload) {
            System.out.println("文件" + multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getSize());
            String originalFilename = multipartFile.getOriginalFilename();
            String newFileName = format + "_" + originalFilename;
            //保存路径
            String path = "D://jtjsfwcenter//file//" + newFileName;
            //生成保存文件
            File destFile = new File(path);
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            System.out.println(destFile);
            Map map = new HashMap<>();
            map.put("newFileName", newFileName);
            map.put("Url", newFileName);
            map.put("size", multipartFile.getSize());
            map.put("suffix", suffix);
            list.add(map);
            //将上传文件保存到路径
            try {
                multipartFile.transferTo(destFile);
                if(suffix.equals("docx")){
                    String prefix = newFileName.substring(0,newFileName.lastIndexOf("."));
                    try  {
                        File outputFile = new File("D:\\jtjsfwcenter\\file\\"+prefix+".pdf");
                        outputFile.createNewFile();
                        InputStream docxInputStream = new FileInputStream(destFile);
                        OutputStream outputStream = new FileOutputStream(outputFile);
                        IConverter converter = LocalConverter.builder().build();
                        converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
                        outputStream.close();
                        System.out.println("success");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(suffix.equals("doc")){
                    String prefix = newFileName.substring(0,newFileName.lastIndexOf("."));
                    try  {
                        File outputFile = new File("D:\\jtjsfwcenter\\file\\"+prefix+".pdf");
                        outputFile.createNewFile();
                        InputStream docxInputStream = new FileInputStream(destFile);
                        OutputStream outputStream = new FileOutputStream(outputFile);
                        IConverter converter = LocalConverter.builder().build();
                        converter.convert(docxInputStream).as(DocumentType.DOC).to(outputStream).as(DocumentType.PDF).execute();
                        outputStream.close();
                        System.out.println("success");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Result.ok(ResultCodeEnum.SUCCESS, list);
    }

    @PostMapping("deletefile")
    public Object deletefile(String fileUpload) {
        File file = new File("d://img//", fileUpload);
        file.delete();
        return Result.ok(ResultCodeEnum.SUCCESS);
    }


    @GetMapping("getTask")
    public Result selectByPrimaryKey(String id) {
        TTask tTask = this.tTaskService.selectByPrimaryKey(id);
        if(null != tTask){
            return Result.ok(ResultCodeEnum.SUCCESS,tTask);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @PostMapping("updateTask")
    public Result updateByPrimaryKeySelective(@RequestBody TTask tTask) {
        if(this.tTaskService.updateByPrimaryKeySelective(tTask) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("查询所有")
    @GetMapping("findByAllTask")
    public Result findByAll(String page, String limit,TTask tTask,String issue,String startDate,String endDate,String order,String by,String stutas,String assigned,String isitoverdue,String deptId,String startsDate,String staDate ) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TTask> tTasks = this.tTaskService.findByAll(tTask,startDate,endDate,stutas,assigned,deptId,isitoverdue,startsDate,staDate);
        Map map =  new HashMap();
        map.put("tStandardizingSystems",tTasks);
        map.put("total", tTasks.size());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }

    @PostMapping("saveEvaluate")
    public Result insertSelective(TTask tTask) {
        if(this.tTaskService.updateByPrimaryKeySelective(tTask) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @GetMapping("getSubtask")
    public Result selectSubtaskByPrimaryKey(String id) {
        TSubtask tSubtask = this.tSubtaskService.selectByPrimaryKey(id);
        TTask tTask = this.tTaskService.selectByPrimaryKey(tSubtask.getTid());

        if(null != tTask){
            Map map = new HashMap();
            map.put("tSubtask",tSubtask);
            map.put("tTask",tTask);
            return Result.ok(ResultCodeEnum.SUCCESS,map);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @PostMapping("updateSubtask")
    public Result updateSubtaskByPrimaryKeySelective(@RequestBody TSubtask tSubtask) {

        if(this.tSubtaskService.updateByPrimaryKeySelective(tSubtask) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @PostMapping("delTask")
    public Result deleteByPrimaryKey(String id) {
        if(this.tTaskService.deleteByPrimaryKey(id) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @PostMapping("delSubtask")
    public Result deleteBySubPrimaryKey(String id) {
        if(this.tSubtaskService.deleteByPrimaryKey(id) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }
}
