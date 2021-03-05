package cn.com.busi.controller;

import cn.com.busi.domain.*;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TJobsService;
import cn.com.busi.service.TPermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("Jobs")
public class JobsController {

    @Resource
    private TJobsService tJobsService;

    @Resource
    private TPermissionService tPermissionService;

    Map map;

    @PostMapping("saveJobs")
    public Object insertSelective(TJobs tJobs) {
        int i = this.tJobsService.insertSelective(tJobs);
        map = new HashMap<>();
        if (i == 1) {
            TPermission tPermission = new TPermission();
            tPermission.setId(tJobs.getId());
            tPermission.setName(tJobs.getName());
            tPermission.setDesc(tJobs.getIntroduction());
            int j = tPermissionService.insertSelective(tPermission);
            if (j == 1) {
                map.put("code", "20000");
                return Result.ok(ResultCodeEnum.SUCCESS);
            }
        }

        return 400;
    }

    @PostMapping("delJobs")
    public Object deleteByPrimaryKey(String id) {
        int i = this.tJobsService.deleteByPrimaryKey(id);
        map = new HashMap<>();
        if (i == 1) {
            int j = this.tPermissionService.deleteByPrimaryKey(id);
            if (j == 1) {
                map.put("code", "20000");
                return map;
            }
        }
        return 400;
    }

    @GetMapping("getJobs")
    public Object selectByPrimaryKey(String id) {
        TJobs tJobs = this.tJobsService.selectByPrimaryKey(id);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tJobs", tJobs);
        return map;
    }

    @PostMapping("updateJobs")
    public Object updateByPrimaryKeySelective(TJobs tJobs) {
        int i = this.tJobsService.updateByPrimaryKeySelective(tJobs);
        TPermission tPermission = new TPermission();
        tPermission.setId(tJobs.getId());
        tPermission.setName(tJobs.getName());
        tPermission.setDesc(tJobs.getIntroduction());
        this.tPermissionService.updateByPrimaryKeySelective(tPermission);
        map = new HashMap<>();
        if (i == 1) {
            map.put("code", "20000");
            return map;
        }
        return 4000;
    }

    @GetMapping("findByAllJobs")
    public Object findByAll(TJobs tJobs) {
        List<TJobs> tJobss = this.tJobsService.findByAll(tJobs);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tJobss", tJobss);
        return map;
    }


}
