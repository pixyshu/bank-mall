package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台用户登录日志表(UmsAdminLoginLog)实体类
 *
 * @author shuds
 * @since 2022-03-21 14:57:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminLoginLog implements Serializable {
    private static final long serialVersionUID = -46597345354851817L;
    
    private Long id;
    
    private Long adminId;
    
    private Date createTime;
    
    private String ip;
    
    private String address;
    /**
     * 浏览器登录类型
     */
    private String userAgent;
}


