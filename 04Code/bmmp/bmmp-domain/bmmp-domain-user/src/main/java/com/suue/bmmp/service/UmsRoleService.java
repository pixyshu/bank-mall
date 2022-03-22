package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsMenu;
import com.suue.bmmp.entity.UmsRole;
import java.util.List;

/**
 * 后台用户角色表(UmsRole)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 19:51:28
 */
public interface UmsRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsRole queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsRole 实例对象
     * @return 实例对象
     */
    UmsRole insert(UmsRole umsRole);

    /**
     * 修改数据
     *
     * @param umsRole 实例对象
     * @return 实例对象
     */
    UmsRole update(UmsRole umsRole);

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
     * @param umsRole 筛选条件
     * @return 查询结果
     */
    List<UmsRole> queryAll(UmsRole umsRole);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsRole> getAllForPage(UmsRole umsRole, Integer pageNum, Integer pageSize);

    /**
     * 根据管理员ID获取对应菜单
     */
    List<UmsMenu> getMenuList(Long adminId);
}
