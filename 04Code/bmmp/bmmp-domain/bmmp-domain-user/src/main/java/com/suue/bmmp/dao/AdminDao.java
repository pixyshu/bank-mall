package com.suue.bmmp.dao;

import com.suue.bmmp.entity.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 后台用户表(Admin)表数据库访问层
 *
 * @author shuds
 * @since 2022-03-21 12:21:23
 */
 @Mapper
public interface AdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdmin queryById(Long id);

    /**
     * 统计总行数
     *
     * @param umsAdmin 查询条件
     * @return 总行数
     */
    long count(UmsAdmin umsAdmin);

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 影响行数
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsAdmin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Admin> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsAdmin> entities);

    /**
     * 修改数据
     *
     * @param umsAdmin 实例对象
     * @return 影响行数
     */
    int update(UmsAdmin umsAdmin);

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
     * @param umsAdmin 查询条件
     * @return 对象列表
     */
    List<UmsAdmin> queryAll(UmsAdmin umsAdmin);


    List<UmsAdmin> selectByUsername(@Param("username") String username);

    /**
     * 根据用户和昵称分页查询用户
     * @param keyword
     * @return
     */
    List<UmsAdmin> selectByKeyWords(@Param("keyword") String keyword);

    int updateByPrimaryKeySelective(UmsAdmin admin);
}

