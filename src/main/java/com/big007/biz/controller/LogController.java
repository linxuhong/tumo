package com.big007.biz.controller;

import com.big007.biz.entity.SysLog;
import com.big007.biz.service.LogService;
import com.big007.common.controller.BaseController;
import com.big007.common.exception.GlobalException;
import com.big007.common.utils.QueryPage;
import com.big007.common.utils.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author big007@foxmail.com
 * @date 2019-03-13
 */
@RestController
@RequestMapping("/log")
@Api(value = "LogController", tags = {"日志管理接口"})
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    @PostMapping("/list")
    public R findByPage(@RequestBody SysLog log, QueryPage queryPage) {
        return new R<>(super.getData(logService.list(log, queryPage)));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        try {
            logService.delete(id);
            return new R();
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }
}
