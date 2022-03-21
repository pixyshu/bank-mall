package com.suue.bmmp.dao;

import com.suue.bmmp.entity.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 后台用户角色表(UmsRole)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-21 19:51:28
 */
 @Mapper
public interface UmsRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsRole queryById(Long id);

    /**
     * 统计总行数
     *
     * @param umsRole 查询条件
     * @return 总行数
     */
    long count(UmsRole umsRole);

    /**
     * 新增数据
     *
     * @param umsRole 实例对象
     * @return 影响行数
     */
    int insert(UmsRole umsRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsRole> entities);

    /**
     * 修改数据
     *
     * @param umsRole 实例对象
     * @return 影响行数
     */
    int update(UmsRole umsRole);

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
     * @param umsRole 查询条件
     * @return 对象列表
     */
    List<UmsRole> queryAll(UmsRole umsRole);
}

