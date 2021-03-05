package cn.com.busi.controller;


import cn.com.busi.domain.TStandardizingSystem;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TStandardizingSystemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Api(tags = "制度管理")
@RestController
@RequestMapping("institution")
public class StandardizingController {

    @Resource
    private TStandardizingSystemService tStandardizingSystemService;

    @ApiOperation("新增数据")
    @PostMapping("saveInst")
    public Result insertSelective(@RequestBody TStandardizingSystem tStandardizingSystem) {
        if(this.tStandardizingSystemService.insertSelective(tStandardizingSystem) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @PostMapping("delInst")
    public Result deleteByPrimaryKey(String id) {
        if(this.tStandardizingSystemService.deleteByPrimaryKey(id) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @GetMapping("getInst")
    public Result selectByPrimaryKey(String id) {
        TStandardizingSystem tStandardizingSystem = this.tStandardizingSystemService.selectByPrimaryKey(id);
        if(null != tStandardizingSystem){
            return Result.ok(ResultCodeEnum.SUCCESS,tStandardizingSystem);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @RequestMapping(value = "/updateInst", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result updateByPrimaryKeySelective(@RequestBody TStandardizingSystem tStandardizingSystem) {
        if(this.tStandardizingSystemService.updateByPrimaryKeySelective(tStandardizingSystem) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @GetMapping("findByAllInst")
    public Result findByAll(String page, String limit,TStandardizingSystem tStandardizingSystem,String issue,String startDate,String endDate,String order,String by ) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TStandardizingSystem> tStandardizingSystems = this.tStandardizingSystemService.findByAll(tStandardizingSystem,startDate,endDate,order,by);
        Map map =  new HashMap();
        map.put("tStandardizingSystems",tStandardizingSystems);
        map.put("total", new PageInfo(tStandardizingSystems, intLimit).getTotal());
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
}
