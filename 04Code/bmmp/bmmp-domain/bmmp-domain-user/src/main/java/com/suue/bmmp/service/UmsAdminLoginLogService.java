package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.entity.UmsAdminLoginLog;
import java.util.List;

/**
 * 后台用户登录日志表(UmsAdminLoginLog)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 14:57:57
 */
public interface UmsAdminLoginLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdminLoginLog queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsAdminLoginLog 实例对象
     * @return 实例对象
     */
    UmsAdminLoginLog insert(UmsAdminLoginLog umsAdminLoginLog);

    /**
     * 修改数据
     *
     * @param umsAdminLoginLog 实例对象
     * @return 实例对象
     */
    UmsAdminLoginLog update(UmsAdminLoginLog umsAdminLoginLog);

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
     * @param umsAdminLoginLog 筛选条件
     * @return 查询结果
     */
    List<UmsAdminLoginLog> queryAll(UmsAdminLoginLog umsAdminLoginLog);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<UmsAdminLoginLog> getAllForPage(UmsAdminLoginLog umsAdminLoginLog, Integer pageNum, Integer pageSize);
}
