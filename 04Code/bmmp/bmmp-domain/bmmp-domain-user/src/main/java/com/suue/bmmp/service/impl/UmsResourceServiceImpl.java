package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsResource;
import com.suue.bmmp.dao.UmsResourceDao;
import com.suue.bmmp.service.UmsResourceService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 后台资源表(UmsResource)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 19:50:58
 */
@Service("umsResourceService")
public class UmsResourceServiceImpl implements UmsResourceService {
    @Resource
    private UmsResourceDao umsResourceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsResource queryById(Long id) {
        return this.umsResourceDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsResource 实例对象
     * @return 实例对象
     */
    @Override
    public UmsResource insert(UmsResource umsResource) {
        this.umsResourceDao.insert(umsResource);
        return umsResource;
    }

    /**
     * 修改数据
     *
     * @param umsResource 实例对象
     * @return 实例对象
     */
    @Override
    public UmsResource update(UmsResource umsResource) {
        this.umsResourceDao.update(umsResource);
        return this.queryById(umsResource.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsResourceDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param umsResource 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsResource> queryAll(UmsResource umsResource) {
        return this.umsResourceDao.queryAll(umsResource);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsResource> getAllForPage(UmsResource umsResource,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsResource> umsResourceList = umsResourceDao.queryAll(umsResource);
        return umsResourceList;
    }
}
