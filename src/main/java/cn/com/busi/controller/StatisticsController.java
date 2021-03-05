package cn.com.busi.controller;

import cn.com.busi.domain.TDept;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TDeptService;
import cn.com.busi.service.TTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "统计")
@RestController
@RequestMapping("/info")
public class StatisticsController {

    @Resource
    private TTaskService tTaskService;

    @Resource
    private TDeptService tDeptService;

    @ApiOperation("按任务类型统计")
    @RequestMapping(value = "/taskCountByType", method = RequestMethod.GET)
    public Result countByType() {
        Map map = new HashMap();
        map.put("type",this.tDeptService.countByType());
        map.put("depts",this.tTaskService.countByType());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }

    @ApiOperation("按部门分类统计")
    @RequestMapping(value = "/taskCountByName", method = RequestMethod.GET)
    public Result countByName() {
        Map map = new HashMap();
        map.put("name",this.tTaskService.countByName());
        map.put("depts",this.tDeptService.countByName());
        return Result.ok(ResultCodeEnum.SUCCESS , map);
    }
}
