package cn.com.busi.controller;


import cn.com.busi.domain.TDept;
import cn.com.busi.domain.TEmp;
import cn.com.busi.domain.TNew;
import cn.com.busi.domain.TNewImg;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TDeptService;
import cn.com.busi.service.TEmpService;
import cn.com.busi.service.TNewImgService;
import cn.com.busi.service.TNewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Api(tags = "新闻管理")
@RestController
@RequestMapping("new")
public class NewController {

    @Resource
    private TNewService tNewService;

    @Resource
    private TNewImgService tNewImgService;

    @Resource
    private TEmpService tEmpService;

    @Resource
    private TDeptService tDeptService;

    Map map;

    @ApiOperation("新增数据")
    @PostMapping("saveNew")
    public Result insertSelective(@RequestBody TNew tNew) {
        if (this.tNewService.insertSelective(tNew) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("获取所有人员名和部门名")
    @GetMapping("getEmpsAndDepts")
    public Object getEmp(TEmp tEmp, TDept tDept) {
        List<TEmp> tEmps = tEmpService.findByAll(tEmp);
        List names = new ArrayList<>();
        for (TEmp emp : tEmps) {
            names.add(emp.getName());
        }
        List<TDept> tDepts = tDeptService.findByAll(tDept);
        List depts = new ArrayList<>();
        for (TDept Dept : tDepts) {
            depts.add(Dept.getName());
        }
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("names", names);
        map.put("depts", depts);
        return map;
    }

    @ApiOperation("删除数据")
    @PostMapping("delNew")
    public Result deleteByPrimaryKey(String id) {
        if (this.tNewService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @GetMapping("getNew")
    public Object selectByPrimaryKey(String id) {
        TNew tNew = this.tNewService.selectByPrimaryKey(id);
        tNew.setCtr(tNew.getCtr() + 1);
        this.tNewService.updateByPrimaryKeySelective(tNew);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tNew", tNew);
        return map;
    }

    @ApiOperation("修改数据")
    @PostMapping("updateNew")
    public Result updateByPrimaryKeySelective(@RequestBody TNew tNew) {
        if (this.tNewService.updateByPrimaryKeySelective(tNew) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @GetMapping("findByAllNew")
    public Object findByAll(String page, String limit, TNew tNew, String issue, String startDate, String endDate, String order, String by,String stutas,String depts) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TNew> tNews = this.tNewService.findByAll(tNew, issue, startDate, endDate, order, by,stutas,depts);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tNews", tNews);
        map.put("total", new PageInfo(tNews, intLimit).getTotal());
        return map;
    }

    @ApiOperation("添加图片")
    @PostMapping("saveNewImg")
    public Object saveNewImg(@RequestBody TNewImg tNewImg) throws IOException {
        tNewImg.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        byte[] b = Base64.getDecoder().decode(tNewImg.getImg());
        String type = "";
        if (0x424D == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "bmp";
        } else if (0x8950 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "png";
        } else if (0xFFD8 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "jpg";
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        BufferedImage bi = ImageIO.read(bais);
        String filename = tNewImg.getId() + "." + type;
        File f = new File("D://jtjsfwcenter//file", filename);
        ImageIO.write(bi, type, f);
        tNewImg.setImg(filename);

        int i = this.tNewImgService.insertSelective(tNewImg);
        map = new HashMap<>();
        if (i == 1) {
            map.put("code", "20000");
            map.put("img", tNewImg.getImg());
            return map;
        }
        return 400;
    }

    @ApiOperation("根据id获取图片")
    @GetMapping("getNewImg")
    public Object getNewImg(String id) {
        TNew tNew = this.tNewService.selectByPrimaryKey(id);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tNew", tNew);
        return map;
    }
    // 设置固定的日期格式

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
            System.out.println(destFile);
            map = new HashMap<>();
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

    @PostMapping("deletefile")
    public Object deletefile(String fileUpload) {
        File file = new File("d://img//", fileUpload);
        file.delete();
        map = new HashMap<>();
        map.put("code", "20000");
        return map;
    }

    @ApiOperation("根据条件筛选查询数据")
    @GetMapping("findByType")
    public Result findByType(String page, String limit, TNew tNew, String issue, String startDate, String endDate, String order, String by,String stutas,String depts) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        return Result.ok(ResultCodeEnum.SUCCESS,this.tNewService.findByType(tNew, issue, startDate, endDate, order, by,stutas,depts));
    }
}
