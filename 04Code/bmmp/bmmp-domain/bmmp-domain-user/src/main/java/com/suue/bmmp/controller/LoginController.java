package com.suue.bmmp.controller;

import com.suue.bmmp.service.UmsAdminService;
import com.suue.bmmp.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 登录相关控制类
 *
 * Created by shuds on 2022/3/21
 **/
@RestController
@RequestMapping("/sso")
public class LoginController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminService umsAdminService;
    @Autowired
    private UmsRoleService roleService;



}
