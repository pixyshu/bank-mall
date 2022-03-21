package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台用户权限表(UmsPermission)实体类
 *
 * @author shuds
 * @since 2022-03-21 19:50:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsPermission implements Serializable {
    private static final long serialVersionUID = -99839700411674953L;
    
    private Long id;
    /**
     * 父级权限id
     */
    private Long pid;
    /**
     * 名称
     */
    private String name;
    /**
     * 权限值
     */
    private String value;
    /**
     * 图标
     */
    private String icon;
    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    private Integer type;
    /**
     * 前端资源路径
     */
    private String uri;
    /**
     * 启用状态；0->禁用；1->启用
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 排序
     */
    private Integer sort;
}


