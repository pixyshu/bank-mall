package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.Role;
import com.suue.bmmp.dao.RoleDao;
import com.suue.bmmp.service.RoleService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 后台用户角色表(Role)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 19:51:09
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Long id) {
        return this.roleDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param role 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Role> queryAll(Role role) {
        return this.roleDao.queryAll(role);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<Role> getAllForPage(Role role,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = roleDao.queryAll(role);
        return roleList;
    }
}
