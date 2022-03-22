package com.suue.bmmp.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.BCrypt;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.api.ResultCode;
import com.suue.bmmp.constant.AuthConstant;
import com.suue.bmmp.dao.UmsAdminLoginLogDao;
import com.suue.bmmp.dao.UmsAdminRoleRelationDao;
import com.suue.bmmp.domain.UserDto;
import com.suue.bmmp.domain.add.UmsAdminParam;
import com.suue.bmmp.entity.UmsAdmin;
import com.suue.bmmp.dao.AdminDao;
import com.suue.bmmp.entity.UmsAdminLoginLog;
import com.suue.bmmp.entity.UmsAdminRoleRelation;
import com.suue.bmmp.entity.UmsRole;
import com.suue.bmmp.exception.Asserts;
import com.suue.bmmp.service.UmsAdminCacheService;
import com.suue.bmmp.service.UmsAdminService;
import com.suue.bmmp.service.AuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 后台用户表(Admin)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 12:21:23
 */
@Service("adminService")
public class UmsAdminServiceImpl implements UmsAdminService {
    @Resource
    private AdminDao adminDao;
    @Autowired
    private AuthService authService;
    @Autowired
    private UmsAdminLoginLogDao adminLoginLogDao;
    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;
    @Autowired
    private UmsAdminCacheService adminCacheService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsAdmin queryById(Long id) {
        return this.adminDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public UmsAdmin insert(UmsAdmin umsAdmin) {
        this.adminDao.insert(umsAdmin);
        return umsAdmin;
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        UmsAdmin rawAdmin = adminDao.queryById(id);
        if(rawAdmin.getPassword().equals(admin.getPassword())){
            //与原加密密码相同的不需要修改
            admin.setPassword(null);
        }else{
            //与原加密密码不同的需要加密修改
            if(StrUtil.isEmpty(admin.getPassword())){
                admin.setPassword(null);
            }else{
                admin.setPassword(BCrypt.hashpw(admin.getPassword()));
            }
        }
        int count = adminDao.updateByPrimaryKeySelective(admin);
//        adminCacheService.delAdmin(id);
        return count;
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
     * @param umsAdmin 筛选条件
     * @return 查询结果
     */
    @Override
    public List<UmsAdmin> queryAll(UmsAdmin umsAdmin) {
        return this.adminDao.queryAll(umsAdmin);
    }
  
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<UmsAdmin> getAllForPage(UmsAdmin umsAdmin, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UmsAdmin> brandList = adminDao.queryAll(umsAdmin);
        PageInfo<UmsAdmin> pageInfo = new PageInfo<UmsAdmin>(brandList);
        return pageInfo;
    }

    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UmsAdmin> umsAdminList = adminDao.selectByUsername(umsAdmin.getUsername());
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = BCrypt.hashpw(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminDao.insert(umsAdmin);
        return umsAdmin;
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
        UmsAdmin umsAdmin = queryByUsername(username);
        if(umsAdmin ==null) return;

        // 实力化一个日志对象
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(umsAdmin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());

        // 执行持久层操作
        adminLoginLogDao.insert(loginLog);
    }

    @Override
    public UmsAdmin queryByUsername(String username) {
        List<UmsAdmin> umsAdminList = adminDao.selectByUsername(username);
        if (umsAdminList != null && umsAdminList.size() > 0) {
            return umsAdminList.get(0);
        }
        return null;
    }

    @Override
    public UmsAdmin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UmsAdmin umsAdmin = adminCacheService.getAdmin(userDto.getId());
        if(umsAdmin !=null){
            return umsAdmin;
        }else{
            umsAdmin = adminDao.queryById(userDto.getId());
            adminCacheService.setAdmin(umsAdmin);
            return umsAdmin;
        }
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return adminDao.selectByKeyWords(keyword);
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        adminRoleRelationDao.delByAdminId(adminId);

        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public UserDto loadUserByUsername(String username){
        //获取用户信息
        UmsAdmin umsAdmin = queryByUsername(username);
        if (umsAdmin != null) {
            List<UmsRole> roleList = getRoleList(umsAdmin.getId());
            UserDto userDTO = new UserDto();
            BeanUtils.copyProperties(umsAdmin,userDTO);
            if(CollUtil.isNotEmpty(roleList)){
                List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDTO.setRoles(roleStrList);
            }
            return userDTO;
        }
        return null;
    }
}
