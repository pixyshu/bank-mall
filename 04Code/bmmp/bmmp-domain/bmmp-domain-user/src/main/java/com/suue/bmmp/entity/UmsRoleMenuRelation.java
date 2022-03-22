package com.suue.bmmp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台角色菜单关系表(UmsRoleMenuRelation)实体类
 *
 * @author shuds
 * @since 2022-03-22 16:51:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsRoleMenuRelation implements Serializable {
    private static final long serialVersionUID = -52353975172247980L;
    
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
}


