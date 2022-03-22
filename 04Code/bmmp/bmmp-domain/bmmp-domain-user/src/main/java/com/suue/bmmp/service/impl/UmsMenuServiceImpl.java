package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.dto.UmsMenuNode;
import com.suue.bmmp.entity.UmsMenu;
import com.suue.bmmp.dao.UmsMenuDao;
import com.suue.bmmp.service.UmsMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

/**
 * 后台菜单表(UmsMenu)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 19:49:08
 */
@Service("umsMenuService")
public class UmsMenuServiceImpl implements UmsMenuService {
    @Resource
    private UmsMenuDao umsMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsMenu queryById(Long id) {
        return this.umsMenuDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsMenu 实例对象
     * @return 实例对象
     */
    @Override
    public UmsMenu insert(UmsMenu umsMenu) {
        this.umsMenuDao.insert(umsMenu);
        return umsMenu;
    }

    /**
     * 修改数据
     *
     * @param umsMenu 实例对象
     * @return 实例对象
     */
    @Override
    public UmsMenu update(UmsMenu umsMenu) {
        this.umsMenuDao.update(umsMenu);
        return this.queryById(umsMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsMenuDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param umsMenu 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsMenu> queryAll(UmsMenu umsMenu) {
        return this.umsMenuDao.queryAll(umsMenu);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsMenu> getAllForPage(UmsMenu umsMenu,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsMenu> umsMenuList = umsMenuDao.queryAll(umsMenu);
        return umsMenuList;
    }

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return umsMenuDao.insert(umsMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenu parentMenu = umsMenuDao.queryById(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
        return umsMenuDao.update(umsMenu);
    }

    @Override
    public UmsMenu getItem(Long id) {
        return umsMenuDao.queryById(id);
    }

    @Override
    public int delete(Long id) {
        return umsMenuDao.deleteById(id);
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return umsMenuDao.selectByParentIdOrderBySortDesc(parentId);
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = umsMenuDao.queryAll(new UmsMenu());
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return umsMenuDao.update(umsMenu);
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu, node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }
}
