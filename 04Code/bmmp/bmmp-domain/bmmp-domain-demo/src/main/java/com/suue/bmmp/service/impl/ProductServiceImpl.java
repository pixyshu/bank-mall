package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.Product;
import com.suue.bmmp.dao.ProductDao;
import com.suue.bmmp.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 *  理财产品(Product)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 18:48:33
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Long id) {
        return this.productDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productDao.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productDao.update(product);
        return this.queryById(product.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.productDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param product 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Product> queryAll(Product product) {
        return this.productDao.queryAll(product);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Product> getAllForPage(Product product,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> brandList = productDao.queryAll(product);
        PageInfo<Product> pageInfo = new PageInfo<Product>(brandList);
        return pageInfo;
    }
}
