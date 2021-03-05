package cn.com.busi.controller;


import cn.com.busi.domain.*;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.mapper.TEmpMapper;
import cn.com.busi.result.Result;
import cn.com.busi.service.*;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Api(tags = "人员信息管理")
@RestController
@RequestMapping("staff")
public class StaffController {

    @Resource
    private TEmpService tEmpService;

    @Resource
    private TDeptService tDeptService;

    @ApiOperation("添加数据")
    @PostMapping("saveStaff")
    public Result insertSelective(TEmp tEmp) {
        String md5Password = DigestUtils.md5DigestAsHex(tEmp.getPassword().getBytes());
        System.out.println(md5Password);
        tEmp.setPassword(md5Password);
        if (this.tEmpService.insertSelective(tEmp) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("获取用户")
    @GetMapping("getStaff")
    public Object selectByPrimaryKey(String id) {
        TEmp tEmp = this.tEmpService.selectByPrimaryKey(id);

        Map map = new HashMap<>();
        map.put("code", "20000");
        map.put("tEmp", tEmp);
        map.put("jobsId", tEmp.getJobs());
        return map;
    }

    @ApiOperation("修改用户信息")
    @PostMapping("updateStaff")
    public Result updateStaff(TEmp tEmp) {
        int i = this.tEmpService.updateByPrimaryKeySelective(tEmp);
        if (i == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除用户")
    @PostMapping("delStaff")
    public Result deleteByPrimaryKey(String id) {
        if (this.tEmpService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("查看所有用户")
    @GetMapping("findByAllStaff")
    public Object findByAll(String page, String limit,TEmp tEmp) {
        Integer intPage = Integer.parseInt(page);
        Integer intLimit = Integer.parseInt(limit);
        PageHelper.startPage(intPage, intLimit);
        List<TEmp> tEmps = this.tEmpService.findByAll(tEmp);
        List<TDept> tDepts = this.tDeptService.selectAllDeptAndJobs();

        Map map = new HashMap<>();
        map.put("code", "20000");
        map.put("tEmps", tEmps);
        map.put("tDepts", tDepts);
        map.put("total", new PageInfo(tEmps, intLimit).getTotal());
        return map;
    }

    @ApiOperation("激活用户状态")
    @PostMapping("updateByState")
    public Result updateByState(TEmp tEmp) {
        if (tEmp.getState().equals("1")) {
            tEmp.setState("0");
        } else {
            tEmp.setState("1");
        }
        return Result.ok(ResultCodeEnum.SUCCESS, this.tEmpService.updateByPrimaryKeySelective(tEmp));

    }

    @ApiOperation("重置密码")
    @PostMapping("resetByPwd")
    public Result resetBypassword(TEmp tEmp) {
        tEmp.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        return Result.ok(ResultCodeEnum.SUCCESS);


    }

    @ApiOperation("修改密码")
    @PostMapping("updatePassword")
    public Result updatePassword(String id,String oldPassword ,String newPassword) {
        TEmp tEmp = this.tEmpService.selectByPrimaryKey(id);
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(oldPassword.getBytes());
        if (md5DigestAsHex.equals(tEmp.getPassword()) ) {
            String digestAsHex = DigestUtils.md5DigestAsHex(newPassword.getBytes());
            tEmp.setPassword(digestAsHex);
            int i = this.tEmpService.updateByPrimaryKeySelective(tEmp);
            if (i == 1) {
                return Result.ok(ResultCodeEnum.SUCCESS);
            }
        }
        return Result.error(ResultCodeEnum.ERROR_PASSWORD);
    }

    @ApiOperation("添加头像")
    @RequestMapping(value = "/img", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Result sendMessage(@RequestParam("img") MultipartFile[] img,@RequestParam("id") String id) {
        System.out.println(img.length);
        String format = String.valueOf(new Date().getTime());
        List<Object> list = new ArrayList<>();
        for (MultipartFile multipartFile : img) {
            System.out.println("文件" + multipartFile.getOriginalFilename());
            System.out.println(multipartFile.getSize());
            String originalFilename = multipartFile.getOriginalFilename();
            String newFileName = format + "_" + originalFilename;
            //保存路径
            String path = "D://jtjsfwcenter//file//img//" + newFileName;
            //生成保存文件
            File destFile = new File(path);
            System.out.println(destFile);
            //将上传文件保存到路径
            TEmp tEmp = new TEmp();
            tEmp.setImg("img/"+newFileName);
            tEmp.setId(id);
            this.tEmpService.updateByPrimaryKeySelective(tEmp);
            try {
                multipartFile.transferTo(destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Result.ok(ResultCodeEnum.SUCCESS,list);
    }
}
