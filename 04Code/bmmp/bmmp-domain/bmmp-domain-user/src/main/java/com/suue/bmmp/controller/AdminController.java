package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.Admin;
import com.suue.bmmp.entity.UmsMenu;
import com.suue.bmmp.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台用户表(Admin)表控制层
 *
 * @author shuds
 * @since 2022-03-21 14:33:39
 */
@RestController
@RequestMapping("admins")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 删除数据
     *
     * @param adminId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{adminId}")
    public CommonResult<Boolean> delete(@PathVariable("adminId") Long adminId) {
        return CommonResult.success(this.adminService.deleteById(adminId));
    }
    
    /**
     * 更新数据
     *
     * @param admin 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<Admin> update(@Valid @RequestBody Admin admin) {
        return CommonResult.success(this.adminService.update(admin));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param adminId 主键
     * @return 单条数据
     */
    @GetMapping("/{adminId}")
    public CommonResult<Admin> get(@PathVariable("adminId") Long adminId) {
        return CommonResult.success(this.adminService.queryById(adminId));
    }

    /**
     * 条件查询
     *
     * @param admin 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<Admin>> getAll(Admin admin) {
        return CommonResult.success(this.adminService.queryAll(admin));
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<Admin>>  getAllForPage(@RequestParam(value = "keyword", required = false) String keyword,
                                                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Admin> adminList = this.adminService.list(keyword,pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(adminList));
    }
}



