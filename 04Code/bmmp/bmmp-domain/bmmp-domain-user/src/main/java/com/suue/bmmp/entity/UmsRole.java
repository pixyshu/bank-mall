package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台用户角色表(UmsRole)实体类
 *
 * @author shuds
 * @since 2022-03-21 19:51:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsRole implements Serializable {
    private static final long serialVersionUID = 707892039247165249L;
    
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 后台用户数量
     */
    private Integer adminCount;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 启用状态：0->禁用；1->启用
     */
    private Integer status;
    
    private Integer sort;
}


