package com.suue.bmmp.controller;

import com.github.pagehelper.PageInfo;
import com.suue.bmmp.api.CommonResult;
import com.suue.bmmp.entity.Product;
import com.suue.bmmp.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *  理财产品(Product)表控制层
 *
 * @author shuds
 * @since 2022-03-21 18:48:33
 */
@RestController
@RequestMapping("products")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 新增数据
     *
     * @param product 实体
     * @return 新增结果
     */
    @PostMapping()
    public CommonResult<Product> create(@Valid @RequestBody Product product) {
        return CommonResult.success(this.productService.insert(product));
    }

    /**
     * 删除数据
     *
     * @param productId 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{productId}")
    public CommonResult<Boolean> delete(@PathVariable("productId") Long productId) {
        return CommonResult.success(this.productService.deleteById(productId));
    }
    
    /**
     * 更新数据
     *
     * @param product 实体
     * @return 编辑结果
     */
    @PutMapping()
    public CommonResult<Product> update(@Valid @RequestBody Product product) {
        return CommonResult.success(this.productService.update(product));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param productId 主键
     * @return 单条数据
     */
    @GetMapping("/{productId}")
    public CommonResult<Product> get(@PathVariable("productId") Long productId) {
        return CommonResult.success(this.productService.queryById(productId));
    }

    /**
     * 条件查询
     *
     * @param product 筛选条件
     * @return 查询结果
     */
    @GetMapping()
    public CommonResult<List<Product>> getAll(Product product) {
        return CommonResult.success(this.productService.queryAll(product));
    }

    /**
     * 条件分页查询
     * @param product 筛选条件
     * @param pageNum 页数
     * @param pageSize 页码
     * @return 查询结果
     */
    @GetMapping("/{pageNum}/{pageSize}")
    public CommonResult<PageInfo<Product>> getAllForPage(Product product
            , @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
            , @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        PageInfo<Product> productPageInfo = this.productService.getAllForPage(product,pageNum, pageSize);
        return CommonResult.success(productPageInfo);
    }
}



