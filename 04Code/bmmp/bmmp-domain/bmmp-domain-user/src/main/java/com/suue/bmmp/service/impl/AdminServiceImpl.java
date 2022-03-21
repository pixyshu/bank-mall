package com.suue.bmmp.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.api.ResultCode;
import com.suue.bmmp.constant.AuthConstant;
import com.suue.bmmp.dao.UmsAdminLoginLogDao;
import com.suue.bmmp.domain.UserDto;
import com.suue.bmmp.domain.add.AdminParam;
import com.suue.bmmp.entity.Admin;
import com.suue.bmmp.dao.AdminDao;
import com.suue.bmmp.entity.UmsAdminLoginLog;
import com.suue.bmmp.exception.Asserts;
import com.suue.bmmp.service.AdminService;
import com.suue.bmmp.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 后台用户表(Admin)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 12:21:23
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;
    @Autowired
    private AuthService authService;
    @Autowired
    private UmsAdminLoginLogDao adminLoginLogDao;

    @Autowired
    private HttpServletRequest request;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Long id) {
        return this.adminDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.adminDao.deleteById(id) > 0;
    }
    
    /**
     * 条件查询
     *
     * @param admin 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Admin> queryAll(Admin admin) {
        return this.adminDao.queryAll(admin);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Admin> getAllForPage(Admin admin,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> brandList = adminDao.queryAll(admin);
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(brandList);
        return pageInfo;
    }

    @Override
    public Admin register(AdminParam adminParam) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setCreateTime(new Date());
        admin.setStatus(1);
        //查询是否有相同用户名的用户
        List<Admin> adminList = adminDao.selectByUsername(admin.getUsername());
        if (adminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(admin.getPassword());
        admin.setPassword(encodePassword);
        adminDao.insert(admin);
        return admin;
    }

    @Override
    public CommonResult login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
            Asserts.fail("用户名或密码不能为空！");

        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        CommonResult restResult = authService.getAccessToken(params);
        if(ResultCode.SUCCESS.getCode()==restResult.getCode()&&restResult.getData()!=null){
//            updateLoginTimeByUsername(username);
            insertLoginLog(username);
        }
        return restResult;
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        // 根据用户名获取当前用户
        Admin admin = queryByUsername(username);
        if(admin==null) return;

        // 实力化一个日志对象
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());

        // 执行持久层操作
        adminLoginLogDao.insert(loginLog);
    }

    @Override
    public Admin queryByUsername(String username) {
        List<Admin> adminList = adminDao.selectByUsername(username);
        if (adminList.size() > 0) {
            return null;
        }
        return adminList.get(0);
    }

    @Override
    public Admin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
//        Admin admin = adminCacheService.getAdmin(userDto.getId());
        Admin admin = new Admin();
        if(admin!=null){
            return admin;
        }else{
            admin = adminDao.queryById(userDto.getId());
//            adminCacheService.setAdmin(admin);
            return admin;
        }
    }

    @Override
    public List<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return adminDao.selectByKeyWords(keyword);
    }
}
