package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.UmsPermission;
import com.suue.bmmp.service.UmsPermissionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台用户权限表(UmsPermission)表控制层
 *
 * @author shuds
 * @since 2022-03-21 19:50:26
 */
@RestController
@RequestMapping("umsPermissions")
public class UmsPermissionController {
    /**
     * 服务对象
     */
    @Resource
    private UmsPermissionService umsPermissionService;

    /**
     * 新增数据
     *
     * @param umsPermission 实体
     * @return 新增结果
     */
    @PostMapping()
    public CommonResult<UmsPermission> create(@Valid @RequestBody UmsPermission umsPermission) {
        return CommonResult.success(this.umsPermissionService.insert(umsPermission));
    }

    /**
     * 删除数据
     *
     * @param umsPermissionId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{umsPermissionId}")
    public CommonResult<Boolean> delete(@PathVariable("umsPermissionId") Long umsPermissionId) {
        return CommonResult.success(this.umsPermissionService.deleteById(umsPermissionId));
    }
    
    /**
     * 更新数据
     *
     * @param umsPermission 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<UmsPermission> update(@Valid @RequestBody UmsPermission umsPermission) {
        return CommonResult.success(this.umsPermissionService.update(umsPermission));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param umsPermissionId 主键
     * @return 单条数据
     */
    @GetMapping("/{umsPermissionId}")
    public CommonResult<UmsPermission> get(@PathVariable("umsPermissionId") Long umsPermissionId) {
        return CommonResult.success(this.umsPermissionService.queryById(umsPermissionId));
    }

    /**
     * 条件查询
     *
     * @param umsPermission 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<UmsPermission>> getAll(UmsPermission umsPermission) {
        return CommonResult.success(this.umsPermissionService.queryAll(umsPermission));
    }

    /**
     * 条件分页查询
     * @param umsPermission 筛选条件
     * @param pageNum 页数
     * @param pageSize 页码
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public CommonResult<CommonPage<UmsPermission>> getAllForPage(UmsPermission umsPermission
            , @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<UmsPermission> umsPermissionList = this.umsPermissionService.getAllForPage(umsPermission, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(umsPermissionList));
    }
}



