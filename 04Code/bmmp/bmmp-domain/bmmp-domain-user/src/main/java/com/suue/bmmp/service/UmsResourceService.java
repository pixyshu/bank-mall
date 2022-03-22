package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsResource;
import java.util.List;
import java.util.Map;

/**
 * 后台资源表(UmsResource)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 19:50:58
 */
public interface UmsResourceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsResource queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsResource 实例对象
     * @return 实例对象
     */
    UmsResource insert(UmsResource umsResource);

    /**
     * 修改数据
     *
     * @param umsResource 实例对象
     * @return 实例对象
     */
    UmsResource update(UmsResource umsResource);

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
     * @param umsResource 筛选条件
     * @return 查询结果
     */
    List<UmsResource> queryAll(UmsResource umsResource);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsResource> getAllForPage(UmsResource umsResource, Integer pageNum, Integer pageSize);

    /**
     * 初始化资源角色规则
     */
    Map<String,List<String>> initResourceRolesMap();
}
