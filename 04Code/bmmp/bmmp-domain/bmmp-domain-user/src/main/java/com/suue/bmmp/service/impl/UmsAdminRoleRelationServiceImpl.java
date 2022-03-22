package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsAdminRoleRelation;
import com.suue.bmmp.dao.UmsAdminRoleRelationDao;
import com.suue.bmmp.service.UmsAdminRoleRelationService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 后台用户和角色关系表(UmsAdminRoleRelation)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 21:15:27
 */
@Service("umsAdminRoleRelationService")
public class UmsAdminRoleRelationServiceImpl implements UmsAdminRoleRelationService {
    @Resource
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsAdminRoleRelation queryById(Long id) {
        return this.umsAdminRoleRelationDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdminRoleRelation insert(UmsAdminRoleRelation umsAdminRoleRelation) {
        this.umsAdminRoleRelationDao.insert(umsAdminRoleRelation);
        return umsAdminRoleRelation;
    }

    /**
     * 修改数据
     *
     * @param umsAdminRoleRelation 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdminRoleRelation update(UmsAdminRoleRelation umsAdminRoleRelation) {
        this.umsAdminRoleRelationDao.update(umsAdminRoleRelation);
        return this.queryById(umsAdminRoleRelation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsAdminRoleRelationDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param umsAdminRoleRelation 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsAdminRoleRelation> queryAll(UmsAdminRoleRelation umsAdminRoleRelation) {
        return this.umsAdminRoleRelationDao.queryAll(umsAdminRoleRelation);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<UmsAdminRoleRelation> getAllForPage(UmsAdminRoleRelation umsAdminRoleRelation,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdminRoleRelation> umsAdminRoleRelationList = umsAdminRoleRelationDao.queryAll(umsAdminRoleRelation);
        return umsAdminRoleRelationList;
    }
}
