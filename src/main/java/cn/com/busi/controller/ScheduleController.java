package cn.com.busi.controller;


import cn.com.busi.domain.TSchedule;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

@Api(tags = "日程事宜管理")
@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Resource
    private TScheduleService tScheduleService;

    @ApiOperation("新增数据")
    @PostMapping("saveSchedule")
    public Result insertSelective(TSchedule tSchedule) {
        if (this.tScheduleService.insertSelective(tSchedule) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @PostMapping("delSchedule")
    public Result deleteByPrimaryKey(String id) {
        if (this.tScheduleService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @GetMapping("getSchedule")
    public Result selectByPrimaryKey(String id) {
        TSchedule tSchedule = this.tScheduleService.selectByPrimaryKey(id);
        if (null != tSchedule) {
            return Result.ok(ResultCodeEnum.SUCCESS, tSchedule);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @PostMapping("updateSchedule")
    public Result updateByPrimaryKeySelective(@RequestBody TSchedule tSchedule) {
        if (this.tScheduleService.updateByPrimaryKeySelective(tSchedule) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @GetMapping("findByAllSchedule")
    public Result findByAll( TSchedule tSchedule, String issue, String start, String end, String order, String by ) {
        List<TSchedule> tSchedules = this.tScheduleService.findByAll(tSchedule,by,start,end);
        Map map =  new HashMap();
        map.put("tSchedules",tSchedules);
        map.put("total", tSchedules.size());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }

    @ApiOperation("添加附件")
    @RequestMapping(value = "/accessory", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object sendMessage(@RequestParam("fileUpload") MultipartFile[] fileUpload) {
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
            System.out.println(destFile);
            Map map = new HashMap<>();
            map.put("newFileName", newFileName);
            map.put("Url", newFileName);
            map.put("size", multipartFile.getSize());
            map.put("suffix", originalFilename.split("\\.")[1]);
            list.add(map);
            //将上传文件保存到路径
            try {
                multipartFile.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Result.ok(ResultCodeEnum.SUCCESS,list);
    }

    @ApiOperation("删除附件")
    @PostMapping("deletefile")
    public Object deletefile(String fileUpload) {
        File file = new File("D://jtjsfwcenter//file", fileUpload);
        file.delete();
        return Result.ok(ResultCodeEnum.SUCCESS);
    }

}
