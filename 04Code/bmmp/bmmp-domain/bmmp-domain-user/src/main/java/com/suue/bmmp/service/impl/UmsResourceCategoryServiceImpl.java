package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.suue.bmmp.entity.UmsResourceCategory;
import com.suue.bmmp.dao.UmsResourceCategoryDao;
import com.suue.bmmp.service.UmsResourceCategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

/**
 * 资源分类表(UmsResourceCategory)表服务实现类
 *
 * @author shuds
 * @since 2022-03-22 18:19:04
 */
@Service("umsResourceCategoryService")
public class UmsResourceCategoryServiceImpl implements UmsResourceCategoryService {
    @Resource
    private UmsResourceCategoryDao umsResourceCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsResourceCategory queryById(Long id) {
        return this.umsResourceCategoryDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsResourceCategory 实例对象
     * @return 实例对象
     */
    @Override
    public UmsResourceCategory insert(UmsResourceCategory umsResourceCategory) {
        this.umsResourceCategoryDao.insert(umsResourceCategory);
        return umsResourceCategory;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Long id) {
        return this.umsResourceCategoryDao.deleteById(id);
    }
    
    /**
     * 条件查询
     *
     * @param umsResourceCategory 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsResourceCategory> queryAll(UmsResourceCategory umsResourceCategory) {
        return this.umsResourceCategoryDao.queryAll(umsResourceCategory);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsResourceCategory> getAllForPage(UmsResourceCategory umsResourceCategory,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsResourceCategory> umsResourceCategoryList = umsResourceCategoryDao.queryAll(umsResourceCategory);
        return umsResourceCategoryList;
    }

    @Override
    public int create(UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setCreateTime(new Date());
        return umsResourceCategoryDao.insert(umsResourceCategory);
    }


    @Override
    public int update(Long id, UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        return umsResourceCategoryDao.update(umsResourceCategory);
    }
}
