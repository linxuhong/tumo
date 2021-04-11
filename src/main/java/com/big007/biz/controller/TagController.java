package com.big007.biz.controller;

import com.big007.biz.entity.SysTag;
import com.big007.biz.service.TagService;
import com.big007.common.annotation.Log;
import com.big007.common.controller.BaseController;
import com.big007.common.exception.GlobalException;
import com.big007.common.utils.QueryPage;
import com.big007.common.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@RestController
@RequestMapping("/tag")
@Api(value = "TagController", tags = {"标签管理接口"})
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysTag tag, QueryPage queryPage) {
        return new R<>(super.getData(tagService.list(tag, queryPage)));
    }

    @PostMapping("/filter/list")
    public R list(@RequestBody SysTag sysTag) {
        return new R<>(tagService.list(sysTag));
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return new R<>(tagService.getById(id));
    }

    @PostMapping
    @Log("新增标签")
    public R save(@RequestBody SysTag tag) {
        try {
            tagService.add(tag);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新标签")
    public R update(@RequestBody SysTag tag) {
        try {
            tagService.update(tag);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除标签")
    public R delete(@PathVariable Long id) {
        try {
            tagService.delete(id);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }
}
