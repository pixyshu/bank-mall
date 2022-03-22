package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.dto.UmsMenuNode;
import com.suue.bmmp.entity.UmsMenu;
import java.util.List;

/**
 * 后台菜单表(UmsMenu)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 19:49:08
 */
public interface UmsMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsMenu queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsMenu 实例对象
     * @return 实例对象
     */
    UmsMenu insert(UmsMenu umsMenu);

    /**
     * 修改数据
     *
     * @param umsMenu 实例对象
     * @return 实例对象
     */
    UmsMenu update(UmsMenu umsMenu);

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
     * @param umsMenu 筛选条件
     * @return 查询结果
     */
    List<UmsMenu> queryAll(UmsMenu umsMenu);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<UmsMenu> getAllForPage(UmsMenu umsMenu, Integer pageNum, Integer pageSize);

    /**
     * 创建后台菜单
     */
    int create(UmsMenu umsMenu);

    /**
     * 修改后台菜单
     */
    int update(Long id, UmsMenu umsMenu);

    /**
     * 根据ID获取菜单详情
     */
    UmsMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<UmsMenuNode> treeList();

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);
}
