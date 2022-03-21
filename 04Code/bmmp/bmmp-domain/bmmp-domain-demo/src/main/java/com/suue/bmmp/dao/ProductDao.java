package com.suue.bmmp.dao;

import com.suue.bmmp.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 *  理财产品(Product)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-21 18:48:33
 */
 @Mapper
public interface ProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Long id);

    /**
     * 统计总行数
     *
     * @param product 查询条件
     * @return 总行数
     */
    long count(Product product);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int insert(Product product);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Product> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Product> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Product> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Product> entities);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int update(Product product);

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
     * @param product 查询条件
     * @return 对象列表
     */
    List<Product> queryAll(Product product);
}

