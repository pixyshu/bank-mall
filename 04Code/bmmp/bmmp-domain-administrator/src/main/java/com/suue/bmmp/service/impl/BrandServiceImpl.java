package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.Brand;
import com.suue.bmmp.dao.BrandDao;
import com.suue.bmmp.service.BrandService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 品牌表(Brand)表服务实现类
 *
 * @author makejava
 * @since 2022-03-04 21:29:28
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Brand queryById(Long id) {
        return this.brandDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @Override
    public Brand insert(Brand brand) {
        this.brandDao.insert(brand);
        return brand;
    }

    /**
     * 修改数据
     *
     * @param brand 实例对象
     * @return 实例对象
     */
    @Override
    public Brand update(Brand brand) {
        this.brandDao.update(brand);
        return this.queryById(brand.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.brandDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param brand 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Brand> queryAll(Brand brand) {
        return this.brandDao.queryAll(brand);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Brand> getAllForPage(Brand brand, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Brand> brandList = brandDao.queryAll(brand);
        PageInfo<Brand> pageInfo = new PageInfo<Brand>(brandList);
        return pageInfo;
    }
}
