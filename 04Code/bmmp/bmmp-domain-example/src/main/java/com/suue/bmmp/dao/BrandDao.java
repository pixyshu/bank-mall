package com.suue.bmmp.dao;

import com.suue.bmmp.entity.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 品牌表(Brand)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-05 14:47:56
 */
 @Mapper
public interface BrandDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Brand queryById(Long id);

    /**
     * 统计总行数
     *
     * @param brand 查询条件
     * @return 总行数
     */
    long count(Brand brand);

    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 影响行数
     */
    int insert(Brand brand);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Brand> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Brand> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Brand> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Brand> entities);

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 影响行数
     */
    int update(Brand brand);

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
     * @param brand 查询条件
     * @return 对象列表
     */
    List<Brand> queryAll(Brand brand);
}

