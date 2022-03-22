package com.suue.bmmp.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * 用户登录参数
 * Created by shuds on 2022/3/21
 **/
@Getter
@Setter
public class UmsAdminParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    private String password;
    @ApiModelProperty(value = "用户头像",name = "http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg")
    private String icon;
    @ApiModelProperty(value = "邮箱",name = "test@163.com")
    @Email
    private String email;
    @ApiModelProperty(value = "用户昵称", name = "test")
    private String nickName;
    @ApiModelProperty(value = "备注", name = "note")
    private String note;
}
