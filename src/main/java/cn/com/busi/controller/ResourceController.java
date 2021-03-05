package cn.com.busi.controller;

import cn.com.busi.domain.TResourceCenter;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TResourceCenterService;
import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

@Api(tags = "资料中心管理")
@RestController
@RequestMapping("resource")
public class ResourceController {

    @Resource
    private TResourceCenterService tResourceCenterService;

    @ApiOperation("新增数据")
    @PostMapping("saveResource")
    public Result insertSelective(TResourceCenter tResourceCenter) {
        if (this.tResourceCenterService.insertSelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @PostMapping("delResource")
    public Result deleteByPrimaryKey(String id) {
        if (this.tResourceCenterService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @GetMapping("getResource")
    public Result selectByPrimaryKey(String id) {
        TResourceCenter tResourceCenter = this.tResourceCenterService.selectByPrimaryKey(id);
        if (null != tResourceCenter) {
            Map map = new HashMap<>();
            map.put("suffix", tResourceCenter.getUrl().substring(tResourceCenter.getUrl().lastIndexOf(".")));
            map.put("tResourceCentre",tResourceCenter);
            return Result.ok(ResultCodeEnum.SUCCESS, map);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @PostMapping("updateResource")
    public Result updateByPrimaryKeySelective(TResourceCenter tResourceCenter) {
        if (this.tResourceCenterService.updateByPrimaryKeySelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
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

    @ApiOperation("删除附件")
    @PostMapping("deletefile")
    public Result deletefile(String fileUpload) {
        File file = new File("D://jtjsfwcenter//file//", fileUpload);
        file.delete();
        return Result.ok(ResultCodeEnum.SUCCESS);
    }

    @ApiOperation("根据条件筛选查询数据")
    @GetMapping("findByAllResource")
    public Result findByAll(String page, String limit, TResourceCenter tResourceCenter, String issue, String startDate, String endDate, String order, String by,String stutas,String depts,String uname ) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TResourceCenter> tResourceCenters = this.tResourceCenterService.findByAll(tResourceCenter,startDate,endDate,stutas,depts,uname);
        Map map =  new HashMap();
        map.put("tResourceCentres",tResourceCenters);
        map.put("total", new PageInfo(tResourceCenters, intLimit).getTotal());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }

    @ApiOperation("阅读量")
    @GetMapping("count")
    public Result count(String id) {
        TResourceCenter tResourceCenter = this.tResourceCenterService.selectByPrimaryKey(id);
        tResourceCenter.setCount(tResourceCenter.getCount()+1);
        if (this.tResourceCenterService.updateByPrimaryKeySelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }
}
