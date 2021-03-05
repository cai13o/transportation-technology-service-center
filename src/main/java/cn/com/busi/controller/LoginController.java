package cn.com.busi.controller;


import cn.com.busi.domain.TEmp;

import cn.com.busi.domain.TPermission;
import cn.com.busi.service.TEmpService;

import cn.com.busi.service.TPermissionService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class LoginController {

    @Resource
    private TEmpService tEmpService;

    @Resource
    private TPermissionService tPermissionService;


    @PostMapping("/login")
    public Object login(String username, String password, HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        TEmp tEmp = tEmpService.selectByUsernameAndPassword(username, md5Password);

        if (tEmp == null) {
            jsonObject.put("message", "用户名或密码错误");
            return jsonObject;
        } else if (!tEmp.getUsername().equals("admin")) {
            TPermission tPermission = tPermissionService.selectByPrimaryKey(tEmp.getJobs());
            if (tEmp.getState() == "0") {
                jsonObject.put("message", "账号未激活");
                return jsonObject;
            } else if (tEmp.getStartdate().getTime() > new Date().getTime()) {
                jsonObject.put("message", "账号未生效");
                return jsonObject;
            } else if (tEmp.getEnddate().getTime() < new Date().getTime()) {
                jsonObject.put("message", "账号已失效");
                return jsonObject;
            } else if (tPermission.getRoute() == null || tPermission.getRoute().equals("")) {
                jsonObject.put("message", "账号未分配权限");
                return jsonObject;
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("data", tEmp);
        jsonObject.put("code", "20000");
        jsonObject.put("token", tEmp.getId() + "-toke");
        jsonObject.put("id", tEmp.getId());
        return jsonObject;

    }


    @GetMapping("/logout")
    public Object loginOut(String id) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "20000");
        jsonObject.put("message", "退出登录");
        return jsonObject;
    }
}