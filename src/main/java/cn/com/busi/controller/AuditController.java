package cn.com.busi.controller;

import cn.com.busi.domain.*;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@Api(tags = "审核管理")
@RestController
@RequestMapping("/audit")
public class AuditController {

    @Resource
    private TNewService tNewService;

    @Resource
    private TResourceCenterService tResourceCenterService;

    @Resource
    private TStandardizingSystemService tStandardizingSystemService;

    @Resource
    private TTaskService tTaskService;

    @Resource
    private TSubtaskService tSubtaskService;


    @ApiOperation("新闻通知审核")
    @PostMapping("updateNew")
    public Object updateByPrimaryKeySelective(TNew tNew) {
        if (this.tNewService.updateByPrimaryKeySelective(tNew) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("资料中心审核")
    @PostMapping("updateResource")
    public Result updateByPrimaryKeySelective(TResourceCenter tResourceCenter) {
        if (this.tResourceCenterService.updateByPrimaryKeySelective(tResourceCenter) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }


    @ApiOperation("制度规范审核")
    @PostMapping("updateInst")
    public Result updateByPrimaryKeySelective(TStandardizingSystem tStandardizingSystem) {
        if(this.tStandardizingSystemService.updateByPrimaryKeySelective(tStandardizingSystem) == 1){
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("任务审核")
    @PostMapping("updateTask")
    public Result updateByPrimaryKeySelective(TTask tTask) {
        if(this.tTaskService.updateByPrimaryKeySelective(tTask) == 1){
            TSubtask tSubtask = new TSubtask();
            tSubtask.setTid(tTask.getId());
            tSubtask.setStatus(tTask.getAuditStatus());
            this.tSubtaskService.updateByTid(tSubtask);
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

}
