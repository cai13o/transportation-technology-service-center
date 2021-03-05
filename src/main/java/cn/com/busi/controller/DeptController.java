package cn.com.busi.controller;

import cn.com.busi.domain.*;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TDeptService;
import cn.com.busi.service.TJobsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Dept")
public class DeptController {

    @Resource
    private TDeptService tDeptService;

    @Resource
    private TJobsService tJobsService;

    Map map;

    @PostMapping("saveDept")
    public Result insertSelective(TDept tDept) {
        if (this.tDeptService.insertSelective(tDept) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @PostMapping("delDept")
    public Object deleteByPrimaryKey(String id) {
        TJobs tJobs = new TJobs();
        tJobs.setDept(id);
        if (this.tJobsService.findByAll(tJobs).size()==0) {
            if (this.tDeptService.deleteByPrimaryKey(id) == 1) {
                return Result.ok(ResultCodeEnum.SUCCESS);
            }
        }
        return Result.error(ResultCodeEnum.ERROR_DEL_DEPT);
    }

    @GetMapping("getDept")
    public Object selectByPrimaryKey(String id) {
        TDept tDept = this.tDeptService.selectByPrimaryKey(id);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tDept", tDept);
        return Result.ok(ResultCodeEnum.SUCCESS, tDept);
    }

    @PostMapping("updateDept")
    public Object updateByPrimaryKeySelective(TDept tDept) {
        int i = this.tDeptService.updateByPrimaryKeySelective(tDept);
        map = new HashMap<>();
        if (i == 1) {
            map.put("code", "20000");
            return map;
        }
        return 4000;
    }

    @GetMapping("findByAllDept")
    public Object findByAll(TDept tDept) {
        List<TDept> tDepts = this.tDeptService.findByAll(tDept);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tDepts", tDepts);
        return map;
    }


}
