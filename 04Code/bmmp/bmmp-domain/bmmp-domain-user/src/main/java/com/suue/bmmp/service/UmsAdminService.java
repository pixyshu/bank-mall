package com.suue.bmmp.service;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.domain.UserDto;
import com.suue.bmmp.domain.add.UmsAdminParam;
import com.suue.bmmp.entity.UmsAdmin;
import com.suue.bmmp.entity.UmsRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 后台用户表(Admin)表服务接口
 *
 * @author shuds
 * @since 2022-03-21 12:21:23
 */
public interface UmsAdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdmin queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    UmsAdmin insert(UmsAdmin umsAdmin);

    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);

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
     * @param umsAdmin 筛选条件
     * @return 查询结果
     */
    List<UmsAdmin> queryAll(UmsAdmin umsAdmin);
  

		/**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<UmsAdmin> getAllForPage(UmsAdmin umsAdmin, Integer pageNum, Integer pageSize);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

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
    UmsAdmin queryByUsername(String username);

    /**
     * 获取当前登录用户信息
     * @return
     */
    UmsAdmin getCurrentAdmin();

    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 根据用户名和昵称分页查询
     *
     */
    List<UmsAdmin> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);
}
