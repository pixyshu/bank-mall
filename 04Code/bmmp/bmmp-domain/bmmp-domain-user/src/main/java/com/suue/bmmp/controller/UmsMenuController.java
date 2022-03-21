package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonPage;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.UmsMenu;
import com.suue.bmmp.service.UmsMenuService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台菜单表(UmsMenu)表控制层
 *
 * @author shuds
 * @since 2022-03-21 19:49:08
 */
@RestController
@RequestMapping("umsMenus")
public class UmsMenuController {
    /**
     * 服务对象
     */
    @Resource
    private UmsMenuService umsMenuService;

    /**
     * 新增数据
     *
     * @param umsMenu 实体
     * @return 新增结果
     */
    @PostMapping()
    public CommonResult<UmsMenu> create(@Valid @RequestBody UmsMenu umsMenu) {
        return CommonResult.success(this.umsMenuService.insert(umsMenu));
    }

    /**
     * 删除数据
     *
     * @param umsMenuId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{umsMenuId}")
    public CommonResult<Boolean> delete(@PathVariable("umsMenuId") Long umsMenuId) {
        return CommonResult.success(this.umsMenuService.deleteById(umsMenuId));
    }
    
    /**
     * 更新数据
     *
     * @param umsMenu 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<UmsMenu> update(@Valid @RequestBody UmsMenu umsMenu) {
        return CommonResult.success(this.umsMenuService.update(umsMenu));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param umsMenuId 主键
     * @return 单条数据
     */
    @GetMapping("/{umsMenuId}")
    public CommonResult<UmsMenu> get(@PathVariable("umsMenuId") Long umsMenuId) {
        return CommonResult.success(this.umsMenuService.queryById(umsMenuId));
    }

    /**
     * 条件查询
     *
     * @param umsMenu 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<UmsMenu>> getAll(UmsMenu umsMenu) {
        return CommonResult.success(this.umsMenuService.queryAll(umsMenu));
    }

    /**
     * 条件分页查询
     * @param umsMenu 筛选条件
     * @param pageNum 页数
     * @param pageSize 页码
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public CommonResult<CommonPage<UmsMenu>> getAllForPage(UmsMenu umsMenu
            , @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        List<UmsMenu> umsMenuList = this.umsMenuService.getAllForPage(umsMenu, pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(umsMenuList));
    }
}



