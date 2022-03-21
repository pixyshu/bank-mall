package com.suue.bmmp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsAdminLoginLog;
import com.suue.bmmp.dao.UmsAdminLoginLogDao;
import com.suue.bmmp.service.UmsAdminLoginLogService;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

/**
 * 后台用户登录日志表(UmsAdminLoginLog)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 14:57:57
 */
@Service("umsAdminLoginLogService")
public class UmsAdminLoginLogServiceImpl implements UmsAdminLoginLogService {
    @Resource
    private UmsAdminLoginLogDao umsAdminLoginLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsAdminLoginLog queryById(Long id) {
        return this.umsAdminLoginLogDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsAdminLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdminLoginLog insert(UmsAdminLoginLog umsAdminLoginLog) {
        this.umsAdminLoginLogDao.insert(umsAdminLoginLog);
        return umsAdminLoginLog;
    }

    /**
     * 修改数据
     *
     * @param umsAdminLoginLog 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdminLoginLog update(UmsAdminLoginLog umsAdminLoginLog) {
        this.umsAdminLoginLogDao.update(umsAdminLoginLog);
        return this.queryById(umsAdminLoginLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsAdminLoginLogDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param umsAdminLoginLog 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsAdminLoginLog> queryAll(UmsAdminLoginLog umsAdminLoginLog) {
        return this.umsAdminLoginLogDao.queryAll(umsAdminLoginLog);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<UmsAdminLoginLog> getAllForPage(UmsAdminLoginLog umsAdminLoginLog,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdminLoginLog> brandList = umsAdminLoginLogDao.queryAll(umsAdminLoginLog);
        PageInfo<UmsAdminLoginLog> pageInfo = new PageInfo<UmsAdminLoginLog>(brandList);
        return pageInfo;
    }
}
