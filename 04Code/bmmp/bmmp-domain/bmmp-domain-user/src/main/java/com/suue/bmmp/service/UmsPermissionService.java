package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsPermission;
import java.util.List;

/**
 * 后台用户权限表(UmsPermission)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 19:50:26
 */
public interface UmsPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsPermission queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsPermission 实例对象
     * @return 实例对象
     */
    UmsPermission insert(UmsPermission umsPermission);

    /**
     * 修改数据
     *
     * @param umsPermission 实例对象
     * @return 实例对象
     */
    UmsPermission update(UmsPermission umsPermission);

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
     * @param umsPermission 筛选条件
     * @return 查询结果
     */
    List<UmsPermission> queryAll(UmsPermission umsPermission);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsPermission> getAllForPage(UmsPermission umsPermission, Integer pageNum, Integer pageSize);
}
