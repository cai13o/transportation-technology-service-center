package cn.com.busi.controller;

import cn.com.busi.domain.TMarquee;
import cn.com.busi.domain.TSchedule;
import cn.com.busi.domain.TTask;
import cn.com.busi.enums.ResultCodeEnum;
import cn.com.busi.result.Result;
import cn.com.busi.service.TMarqueeService;
import cn.com.busi.service.TScheduleService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "跑马灯")
@RestController
@RequestMapping("marquee")
public class MarqueeController {
    @Resource
    private TMarqueeService tMarqueeService;

    @ApiOperation("新增数据")
    @PostMapping("saveMarquee")
    public Result insertSelective(TMarquee tMarquee) {
        if (this.tMarqueeService.insertSelective(tMarquee) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("删除数据")
    @PostMapping("delMarquee")
    public Result deleteByPrimaryKey(String id) {
        if (this.tMarqueeService.deleteByPrimaryKey(id) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据id获取数据")
    @GetMapping("getMarquee")
    public Result selectByPrimaryKey(String id) {
        TMarquee tMarquee = this.tMarqueeService.selectByPrimaryKey(id);
        if (null != tMarquee) {
            return Result.ok(ResultCodeEnum.SUCCESS, tMarquee);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("修改数据")
    @PostMapping("updateMarquee")
    public Result updateByPrimaryKeySelective(TMarquee tMarquee) {
        if (this.tMarqueeService.updateByPrimaryKeySelective(tMarquee) == 1) {
            return Result.ok(ResultCodeEnum.SUCCESS);
        }
        return Result.error(ResultCodeEnum.UNKNOW_REASON);
    }

    @ApiOperation("根据条件筛选查询数据")
    @GetMapping("findByAllMarquee")
    public Result findByAll(String page, String limit, TMarquee tMarquee, String issue, String start, String end, String order, String by) {
        if (null != page && null != limit) {
            Integer intPage = Integer.parseInt(page);
            Integer intLimit = Integer.parseInt(limit);
            PageHelper.startPage(intPage, intLimit);
        }
        List<TMarquee> tMarquees = this.tMarqueeService.findByAll(tMarquee);
        Map map = new HashMap();
        map.put("tStandardizingSystems", tMarquees);
        map.put("total", tMarquees.size());
        return Result.ok(ResultCodeEnum.SUCCESS, map);
    }
}
