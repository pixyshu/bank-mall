package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsAdminRoleRelation;
import java.util.List;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 21:15:27
 */
public interface UmsAdminRoleRelationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdminRoleRelation queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 实例对象
     */
    UmsAdminRoleRelation insert(UmsAdminRoleRelation umsAdminRoleRelation);

    /**
     * 修改数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 实例对象
     */
    UmsAdminRoleRelation update(UmsAdminRoleRelation umsAdminRoleRelation);

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
     * @param umsAdminRoleRelation 筛选条件
     * @return 查询结果
     */
    List<UmsAdminRoleRelation> queryAll(UmsAdminRoleRelation umsAdminRoleRelation);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsAdminRoleRelation> getAllForPage(UmsAdminRoleRelation umsAdminRoleRelation, Integer pageNum, Integer pageSize);
}
