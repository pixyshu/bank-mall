package com.suue.bmmp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)实体类
 *
 * @author shuds
 * @since 2022-03-22 16:53:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsRoleResourceRelation implements Serializable {
    private static final long serialVersionUID = -65615889720220026L;
    
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 资源ID
     */
    private Long resourceId;
}


