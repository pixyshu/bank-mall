package com.suue.bmmp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * TODO
 * Created by shuds on 2022/3/1
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
}
