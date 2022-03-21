package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsRole;
import com.suue.bmmp.dao.UmsRoleDao;
import com.suue.bmmp.service.UmsRoleService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 后台用户角色表(UmsRole)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 19:51:28
 */
@Service("umsRoleService")
public class UmsRoleServiceImpl implements UmsRoleService {
    @Resource
    private UmsRoleDao umsRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsRole queryById(Long id) {
        return this.umsRoleDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsRole 实例对象
     * @return 实例对象
     */
    @Override
    public UmsRole insert(UmsRole umsRole) {
        this.umsRoleDao.insert(umsRole);
        return umsRole;
    }

    /**
     * 修改数据
     *
     * @param umsRole 实例对象
     * @return 实例对象
     */
    @Override
    public UmsRole update(UmsRole umsRole) {
        this.umsRoleDao.update(umsRole);
        return this.queryById(umsRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsRoleDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param umsRole 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsRole> queryAll(UmsRole umsRole) {
        return this.umsRoleDao.queryAll(umsRole);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsRole> getAllForPage(UmsRole umsRole,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsRole> umsRoleList = umsRoleDao.queryAll(umsRole);
        return umsRoleList;
    }
}
