package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.UmsResource;
import com.suue.bmmp.service.UmsResourceService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台资源表(UmsResource)表控制层
 *
 * @author shuds
 * @since 2022-03-21 19:50:58
 */
@Api(tags = "ResourceController", description = "后台资源管理")
@RestController
@RequestMapping("umsResources")
public class UmsResourceController {
    /**
     * 服务对象
     */
    @Resource
    private UmsResourceService umsResourceService;

    /**
     * 新增数据
     *
     * @param umsResource 实体
     * @return 新增结果
     */
    @PostMapping()
    public CommonResult<UmsResource> create(@Valid @RequestBody UmsResource umsResource) {
        return CommonResult.success(this.umsResourceService.insert(umsResource));
    }

    /**
     * 删除数据
     *
     * @param umsResourceId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{umsResourceId}")
    public CommonResult<Boolean> delete(@PathVariable("umsResourceId") Long umsResourceId) {
        return CommonResult.success(this.umsResourceService.deleteById(umsResourceId));
    }
    
    /**
     * 更新数据
     *
     * @param umsResource 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<UmsResource> update(@Valid @RequestBody UmsResource umsResource) {
        return CommonResult.success(this.umsResourceService.update(umsResource));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param umsResourceId 主键
     * @return 单条数据
     */
    @GetMapping("/{umsResourceId}")
    public CommonResult<UmsResource> get(@PathVariable("umsResourceId") Long umsResourceId) {
        return CommonResult.success(this.umsResourceService.queryById(umsResourceId));
    }

    /**
     * 条件查询
     *
     * @param umsResource 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<UmsResource>> getAll(UmsResource umsResource) {
        return CommonResult.success(this.umsResourceService.queryAll(umsResource));
    }

    /**
     * 条件分页查询
     * @param umsResource 筛选条件
     * @param pageNum 页数
     * @param pageSize 页码
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public CommonResult<CommonPage<UmsResource>> getAllForPage(UmsResource umsResource
            , @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<UmsResource> umsResourceList = this.umsResourceService.getAllForPage(umsResource, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(umsResourceList));
    }
}



