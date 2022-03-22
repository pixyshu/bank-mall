package com.suue.bmmp.service;

import com.suue.bmmp.entity.UmsResourceCategory;
import java.util.List;

/**
 * 资源分类表(UmsResourceCategory)表服务接口
 *
 * @author shuds
 * @since 2022-03-22 18:19:04
 */
public interface UmsResourceCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsResourceCategory queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsResourceCategory 实例对象
     * @return 实例对象
     */
    UmsResourceCategory insert(UmsResourceCategory umsResourceCategory);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Long id);

    /**
     * 条件查询
     *
     * @param umsResourceCategory 筛选条件
     * @return 查询结果
     */
    List<UmsResourceCategory> queryAll(UmsResourceCategory umsResourceCategory);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsResourceCategory> getAllForPage(UmsResourceCategory umsResourceCategory, Integer pageNum, Integer pageSize);

    int create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);
}
