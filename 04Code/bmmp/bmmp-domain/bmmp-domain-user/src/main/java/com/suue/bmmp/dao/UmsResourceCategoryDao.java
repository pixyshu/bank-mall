package com.suue.bmmp.dao;

import com.suue.bmmp.entity.UmsResourceCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 资源分类表(UmsResourceCategory)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-22 18:19:04
 */
 @Mapper
public interface UmsResourceCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsResourceCategory queryById(Long id);

    /**
     * 统计总行数
     *
     * @param umsResourceCategory 查询条件
     * @return 总行数
     */
    long count(UmsResourceCategory umsResourceCategory);

    /**
     * 新增数据
     *
     * @param umsResourceCategory 实例对象
     * @return 影响行数
     */
    int insert(UmsResourceCategory umsResourceCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsResourceCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsResourceCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsResourceCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsResourceCategory> entities);

    /**
     * 修改数据
     *
     * @param umsResourceCategory 实例对象
     * @return 影响行数
     */
    int update(UmsResourceCategory umsResourceCategory);

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
     * @param umsResourceCategory 查询条件
     * @return 对象列表
     */
    List<UmsResourceCategory> queryAll(UmsResourceCategory umsResourceCategory);
}

