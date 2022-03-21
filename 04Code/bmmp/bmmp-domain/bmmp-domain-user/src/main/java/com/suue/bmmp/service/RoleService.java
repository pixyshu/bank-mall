package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.Role;
import java.util.List;

/**
 * 后台用户角色表(Role)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 19:51:09
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Long id);

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

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
     * @param role 筛选条件
     * @return 查询结果
     */
    List<Role> queryAll(Role role);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Role> getAllForPage(Role role, Integer pageNum, Integer pageSize);
}
