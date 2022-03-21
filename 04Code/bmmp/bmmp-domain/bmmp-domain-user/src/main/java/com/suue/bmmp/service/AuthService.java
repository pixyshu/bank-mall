package com.suue.bmmp.service;

import com.suue.bmmp.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

/**
 * 认证服务远程调用
 * Created by shuds on 2022/3/20
 **/
@Service
@FeignClient(value = "platform-authority-service")
public interface AuthService {

    @PostMapping(value = "/oauth/token")
    CommonResult getAccessToken(@RequestParam Map<String, String> parameters);
}
