package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsPermission;
import com.suue.bmmp.dao.UmsPermissionDao;
import com.suue.bmmp.service.UmsPermissionService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 后台用户权限表(UmsPermission)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 19:50:26
 */
@Service("umsPermissionService")
public class UmsPermissionServiceImpl implements UmsPermissionService {
    @Resource
    private UmsPermissionDao umsPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsPermission queryById(Long id) {
        return this.umsPermissionDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsPermission 实例对象
     * @return 实例对象
     */
    @Override
    public UmsPermission insert(UmsPermission umsPermission) {
        this.umsPermissionDao.insert(umsPermission);
        return umsPermission;
    }

    /**
     * 修改数据
     *
     * @param umsPermission 实例对象
     * @return 实例对象
     */
    @Override
    public UmsPermission update(UmsPermission umsPermission) {
        this.umsPermissionDao.update(umsPermission);
        return this.queryById(umsPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsPermissionDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param umsPermission 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsPermission> queryAll(UmsPermission umsPermission) {
        return this.umsPermissionDao.queryAll(umsPermission);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsPermission> getAllForPage(UmsPermission umsPermission,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsPermission> umsPermissionList = umsPermissionDao.queryAll(umsPermission);
        return umsPermissionList;
    }
}
