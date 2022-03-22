package com.suue.bmmp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)实体类
 *
 * @author shuds
 * @since 2022-03-21 21:15:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsAdminRoleRelation implements Serializable {
    private static final long serialVersionUID = -65740410685697816L;
    
    private Long id;
    
    private Long adminId;
    
    private Long roleId;
}


