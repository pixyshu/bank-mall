package com.suue.bmmp.dao;

import com.suue.bmmp.entity.UmsRoleResourceRelation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 后台角色资源关系表(UmsRoleResourceRelation)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-22 16:53:27
 */
 @Mapper
public interface UmsRoleResourceRelationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsRoleResourceRelation queryById(Long id);

    /**
     * 统计总行数
     *
     * @param umsRoleResourceRelation 查询条件
     * @return 总行数
     */
    long count(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 新增数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 影响行数
     */
    int insert(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsRoleResourceRelation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsRoleResourceRelation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsRoleResourceRelation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsRoleResourceRelation> entities);

    /**
     * 修改数据
     *
     * @param umsRoleResourceRelation 实例对象
     * @return 影响行数
     */
    int update(UmsRoleResourceRelation umsRoleResourceRelation);

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
     * @param umsRoleResourceRelation 查询条件
     * @return 对象列表
     */
    List<UmsRoleResourceRelation> queryAll(UmsRoleResourceRelation umsRoleResourceRelation);

    /**
     * 根据角色ID删除记录
     * @param roleId
     * @return
     */
    int delByRoleId(@Param("roleId") Long roleId);
}

