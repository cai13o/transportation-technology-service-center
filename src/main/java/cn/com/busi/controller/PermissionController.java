package cn.com.busi.controller;

import cn.com.busi.domain.TPermission;
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
@RequestMapping("permission")
public class PermissionController {
    @Resource
    private TPermissionService tPermissionService;

    Map map;

    @PostMapping("savePermission")
    public Object insertSelective(TPermission tPermission) {
        int i = this.tPermissionService.insertSelective(tPermission);
        map = new HashMap<>();
        if(i==1){
            map.put("code", "20000");
            return map;
        }

        return 400;
    }

    @PostMapping("delPermission")
    public Object deleteByPrimaryKey(String id){
        int i = this.tPermissionService.deleteByPrimaryKey(id);
        map = new HashMap<>();
        if(i==1){
            map.put("code", "20000");
            return map;
        }
        return 400;
    }

    @GetMapping("getPermission")
    public Object selectByPrimaryKey(String id){
        TPermission tPermission = this.tPermissionService.selectByPrimaryKey(id);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tPermission", tPermission);
        return map;
    }

    @PostMapping("updatePermission")
    public Object updateByPrimaryKeySelective(TPermission tPermission){
        int i = this.tPermissionService.updateByPrimaryKeySelective(tPermission);
        map = new HashMap<>();
        if(i==1){
            map.put("code", "20000");
            return map;
        }
        return 4000;
    }

    @GetMapping("findByAllPermission")
    public Object findByAll(TPermission tPermission){
        List<TPermission> tPermissions = this.tPermissionService.selectByAll(tPermission);
        map = new HashMap<>();
        map.put("code", "20000");
        map.put("tPermissions", tPermissions);
        return map;
    }
}
