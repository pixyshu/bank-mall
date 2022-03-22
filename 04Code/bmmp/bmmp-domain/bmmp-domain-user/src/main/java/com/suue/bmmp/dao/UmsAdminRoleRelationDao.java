package com.suue.bmmp.dao;

import com.suue.bmmp.entity.UmsAdminRoleRelation;
import com.suue.bmmp.entity.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-21 21:15:27
 */
 @Mapper
public interface UmsAdminRoleRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdminRoleRelation queryById(Long id);

    /**
     * 统计总行数
     *
     * @param umsAdminRoleRelation 查询条件
     * @return 总行数
     */
    long count(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 新增数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 影响行数
     */
    int insert(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsAdminRoleRelation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsAdminRoleRelation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsAdminRoleRelation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsAdminRoleRelation> entities);

    /**
     * 修改数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 影响行数
     */
    int update(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 条件查询所有数据
     *
     * @param umsAdminRoleRelation 查询条件
     * @return 对象列表
     */
    List<UmsAdminRoleRelation> queryAll(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

    /**
     * 删除指定用户的所有角色
     */
    int delByAdminId(@Param("adminId") Long adminId);

    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<UmsAdminRoleRelation> adminRoleRelationList);
}

