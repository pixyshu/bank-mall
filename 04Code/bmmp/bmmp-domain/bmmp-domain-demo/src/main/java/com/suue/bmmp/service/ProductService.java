package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.Product;
import java.util.List;

/**
 *  理财产品(Product)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 18:48:33
 */
public interface ProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Long id);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product update(Product product);

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
     * @param product 筛选条件
     * @return 查询结果
     */
    List<Product> queryAll(Product product);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Product> getAllForPage(Product product, Integer pageNum, Integer pageSize);
}
