package com.big007.biz.controller;

import com.big007.biz.entity.SysUser;
import com.big007.biz.service.UserService;
import com.big007.common.annotation.Log;
import com.big007.common.controller.BaseController;
import com.big007.common.exception.GlobalException;
import com.big007.common.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户功能接口
 *
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = {"用户功能接口"})
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public R getInfo() {
        return new R<>(this.getCurrentUser());
    }

    @GetMapping("/findByName")
    public R findByName(String username) {
        return new R<>(userService.findByName(username));
    }

    @GetMapping("/checkName")
    public R checkName(String username) {
        return new R<>(userService.checkName(username, this.getCurrentUser().getUsername()));
    }

    @GetMapping("/{id}")
    public R findById(@PathVariable Long id) {
        return new R<>(userService.getById(id));
    }

    @PostMapping
    @Log("新增用户")
    public R add(@RequestBody SysUser sysUser) {
        try {
            userService.add(sysUser);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping
    @Log("更新用户")
    public R update(@RequestBody SysUser sysUser) {
        try {
            userService.update(sysUser);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @PutMapping("/changePass")
    @Log("修改密码")
    public R updatePass(@RequestBody SysUser sysUser) {
        try {
            userService.updatePass(sysUser);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Log("删除用户")
    public R delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return new R();
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }
    }

    @GetMapping("/chart")
    public R chart() {
        return new R<>(userService.chart());
    }
}
