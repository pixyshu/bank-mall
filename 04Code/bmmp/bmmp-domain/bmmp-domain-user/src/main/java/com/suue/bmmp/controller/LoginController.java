package com.suue.bmmp.controller;

import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.domain.UmsAdminLoginParam;
import com.suue.bmmp.domain.add.AdminParam;
import com.suue.bmmp.entity.Admin;
import com.suue.bmmp.service.AdminService;
import com.suue.bmmp.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录相关控制类
 *
 * Created by shuds on 2022/3/21
 **/
@RestController
@RequestMapping("sso")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult<Admin> register(@Validated @RequestBody AdminParam adminParam) {
        Admin admin = adminService.register(adminParam);
        if (admin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(admin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        return adminService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
    }


    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo() {
        Admin admin = adminService.getCurrentAdmin();
        Map<String, Object> data = new HashMap<>();
        data.put("username", admin.getUsername());
//        data.put("menus", roleService.getMenuList(admin.getId()));
        data.put("icon", admin.getIcon());

//        List<UmsRole> roleList = adminService.getRoleList(admin.getId());
//        if(CollUtil.isNotEmpty(roleList)){
//            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
//            data.put("roles",roles);
//        }
        return CommonResult.success(data);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }


}
