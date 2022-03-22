package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 资源分类表(UmsResourceCategory)实体类
 *
 * @author shuds
 * @since 2022-03-22 18:19:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsResourceCategory implements Serializable {
    private static final long serialVersionUID = -62604604931763519L;
    
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 排序
     */
    private Integer sort;
}


