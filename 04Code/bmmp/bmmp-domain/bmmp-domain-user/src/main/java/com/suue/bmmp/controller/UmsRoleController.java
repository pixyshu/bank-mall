package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.UmsRole;
import com.suue.bmmp.service.UmsRoleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台用户角色表(UmsRole)表控制层
 *
 * @author shuds
 * @since 2022-03-21 19:51:28
 */
@RestController
@RequestMapping("umsRoles")
public class UmsRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UmsRoleService umsRoleService;

    /**
     * 新增数据
     *
     * @param umsRole 实体
     * @return 新增结果
     */
    @PostMapping()
    public CommonResult<UmsRole> create(@Valid @RequestBody UmsRole umsRole) {
        return CommonResult.success(this.umsRoleService.insert(umsRole));
    }

    /**
     * 删除数据
     *
     * @param umsRoleId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{umsRoleId}")
    public CommonResult<Boolean> delete(@PathVariable("umsRoleId") Long umsRoleId) {
        return CommonResult.success(this.umsRoleService.deleteById(umsRoleId));
    }
    
    /**
     * 更新数据
     *
     * @param umsRole 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<UmsRole> update(@Valid @RequestBody UmsRole umsRole) {
        return CommonResult.success(this.umsRoleService.update(umsRole));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param umsRoleId 主键
     * @return 单条数据
     */
    @GetMapping("/{umsRoleId}")
    public CommonResult<UmsRole> get(@PathVariable("umsRoleId") Long umsRoleId) {
        return CommonResult.success(this.umsRoleService.queryById(umsRoleId));
    }

    /**
     * 条件查询
     *
     * @param umsRole 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<UmsRole>> getAll(UmsRole umsRole) {
        return CommonResult.success(this.umsRoleService.queryAll(umsRole));
    }

    /**
     * 条件分页查询
     * @param umsRole 筛选条件
     * @param pageNum 页数
     * @param pageSize 页码
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public CommonResult<CommonPage<UmsRole>> getAllForPage(UmsRole umsRole
            , @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<UmsRole> umsRoleList = this.umsRoleService.getAllForPage(umsRole, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(umsRoleList));
    }
}



