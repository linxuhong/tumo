package com.big007.biz.controller;

import com.big007.biz.entity.SysCategory;
import com.big007.biz.service.CategoryService;
import com.big007.common.annotation.Log;
import com.big007.common.controller.BaseController;
import com.big007.common.exception.GlobalException;
import com.big007.common.utils.QueryPage;
import com.big007.common.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 分类功能接口
 *
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@RestController
@RequestMapping("/category")
@Api(value = "CategoryController", tags = {"分类功能接口"})
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/list")
    public R<Map<String, Object>> list(@RequestBody SysCategory sysCategory, QueryPage queryPage) {
        return new R<>(super.getData(categoryService.list(sysCategory, queryPage)));
    }

    @PostMapping("/filter/list")
    public R list(@RequestBody SysCategory sysCategory) {
        return new R<>(categoryService.list(sysCategory));
    }

    @GetMapping("/{id}")
    public R<SysCategory> findById(@PathVariable("id") Long id) {
        return new R<>(categoryService.getById(id));
    }

    @PostMapping
    @Log("新增分类")
    public R save(@RequestBody SysCategory sysCategory) {
        try {
            categoryService.add(sysCategory);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新分类")
    public R update(@RequestBody SysCategory sysCategory) {
        try {
            categoryService.update(sysCategory);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除分类")
    public R delete(@PathVariable Long id) {
        try {
            categoryService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
