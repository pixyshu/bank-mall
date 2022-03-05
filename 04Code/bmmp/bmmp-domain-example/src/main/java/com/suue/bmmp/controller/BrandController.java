package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.Brand;
import com.suue.bmmp.service.BrandService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 品牌表(Brand)表控制层
 *
 * @author shuds
 * @since 2022-03-05 14:47:56
 */
@RestController
@RequestMapping("brands")
public class BrandController {
    /**
     * 服务对象
     */
    @Resource
    private BrandService brandService;

    /**
     * 新增数据
     *
     * @param brand 实体
     * @return 新增结果
     */
    @PostMapping()
    public CommonResult<Brand> create(@Valid @RequestBody Brand brand) {
        return CommonResult.success(this.brandService.insert(brand));
    }

    /**
     * 删除数据
     *
     * @param brandId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{brandId}")
    public CommonResult<Boolean> delete(@PathVariable("brandId") Long brandId) {
        return CommonResult.success(this.brandService.deleteById(brandId));
    }
    
    /**
     * 更新数据
     *
     * @param brand 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<Brand> update(@Valid @RequestBody Brand brand) {
        return CommonResult.success(this.brandService.update(brand));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param brandId 主键
     * @return 单条数据
     */
    @GetMapping("/{brandId}")
    public CommonResult<Brand> get(@PathVariable("brandId") Long brandId) {
        return CommonResult.success(this.brandService.queryById(brandId));
    }

    /**
     * 条件查询
     *
     * @param brand 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<Brand>> getAll(Brand brand) {
        return CommonResult.success(this.brandService.queryAll(brand));
    }

    /**
     * 条件分页查询
     * @param brand 筛选条件
     * @param pageNum 页数
     * @param pageSize 页码
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public CommonResult<PageInfo<Brand>> getAllForPage(Brand brand
            , @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageInfo<Brand> brandPageInfo = this.brandService.getAllForPage(brand,pageNum, pageSize);
        return CommonResult.success(brandPageInfo);
    }
}



