package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台资源表(UmsResource)实体类
 *
 * @author shuds
 * @since 2022-03-21 19:50:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsResource implements Serializable {
    private static final long serialVersionUID = 523679104085113736L;
    
    private Long id;
    /**
     * 资源分类ID
     */
    private Long categoryId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源URL
     */
    private String url;
    /**
     * 描述
     */
    private String description;
}


