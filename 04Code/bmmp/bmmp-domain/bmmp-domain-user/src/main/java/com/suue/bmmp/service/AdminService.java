package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.domain.add.AdminParam;
import com.suue.bmmp.entity.Admin;
import java.util.List;

/**
 * 后台用户表(Admin)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 12:21:23
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Long id);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin update(Admin admin);

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
     * @param admin 筛选条件
     * @return 查询结果
     */
    List<Admin> queryAll(Admin admin);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Admin> getAllForPage(Admin admin, Integer pageNum, Integer pageSize);

    /**
     * 注册功能
     */
    Admin register(AdminParam adminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 调用认证中心返回结果
     */
    CommonResult login(String username, String password);

    /**
     * 根据用户名查询
     * @param username
     * @return Admin
     */
    Admin queryByUsername(String username);

    /**
     * 获取当前登录用户信息
     * @return
     */
    Admin getCurrentAdmin();

    /**
     * 根据用户名和昵称分页查询
     *
     */
    List<Admin> list(String keyword, Integer pageNum, Integer pageSize);
}
