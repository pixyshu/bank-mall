package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsMenu;
import com.suue.bmmp.dao.UmsMenuDao;
import com.suue.bmmp.service.UmsMenuService;
import org.springframework.stereotype.Service;
import java.util.List;

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
}
