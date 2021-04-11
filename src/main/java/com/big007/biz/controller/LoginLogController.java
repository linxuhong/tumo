package com.big007.biz.controller;

import com.big007.common.annotation.Log;
import com.big007.common.controller.BaseController;
import com.big007.common.exception.GlobalException;
import com.big007.common.utils.QueryPage;
import com.big007.common.utils.R;
import com.big007.biz.entity.SysLoginLog;
import com.big007.biz.service.LoginLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
@RestController
@RequestMapping("/loginlog")
@Api(value = "LoginLogController", tags = {"登录日志管理接口"})
public class LoginLogController extends BaseController {

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLoginLog sysLoginLog, QueryPage queryPage) {
        return new R<>(super.getData(loginLogService.list(sysLoginLog, queryPage)));
    }

    @Log("删除登录日志")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            loginLogService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
