package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.Brand;
import java.util.List;

/**
 * 品牌表(Brand)表服务接口
 *
 * @author shuds
 * @since 2022-03-05 14:47:56
 */
public interface BrandService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Brand queryById(Long id);

    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    Brand insert(Brand brand);

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    Brand update(Brand brand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 条件查询
     *
     * @param brand 筛选条件
     * @return 查询结果
     */
    List<Brand> queryAll(Brand brand);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Brand> getAllForPage(Brand brand, Integer pageNum, Integer pageSize);
}
