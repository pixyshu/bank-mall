package com.suue.bmmp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * UserDTO 用户数据传输对象类
 * Created by shuds on 2022/3/1
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
