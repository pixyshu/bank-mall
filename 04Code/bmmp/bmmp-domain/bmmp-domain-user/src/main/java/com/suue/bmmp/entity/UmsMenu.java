package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台菜单表(UmsMenu)实体类
 *
 * @author shuds
 * @since 2022-03-21 19:49:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsMenu implements Serializable {
    private static final long serialVersionUID = -46521100259593950L;
    
    private Long id;
    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 菜单名称
     */
    private String title;
    /**
     * 菜单级数
     */
    private Integer level;
    /**
     * 菜单排序
     */
    private Integer sort;
    /**
     * 前端名称
     */
    private String name;
    /**
     * 前端图标
     */
    private String icon;
    /**
     * 前端隐藏
     */
    private Integer hidden;
}


