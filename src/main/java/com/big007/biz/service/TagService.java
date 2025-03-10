package com.big007.biz.service;

import com.big007.biz.entity.SysTag;
import com.big007.common.utils.QueryPage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author big007@foxmail.com
 * @date 2020/6/27
 */
public interface TagService extends IService<SysTag> {

    IPage<SysTag> list(SysTag tag, QueryPage queryPage);

    List<SysTag> list(SysTag sysTag);

    void add(SysTag tag);

    void update(SysTag tag);

    void delete(Long id);

    List<SysTag> findByArticleId(Long id);

}
