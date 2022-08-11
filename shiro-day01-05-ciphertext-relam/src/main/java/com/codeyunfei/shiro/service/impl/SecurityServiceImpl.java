package com.codeyunfei.shiro.service.impl;

import com.codeyunfei.shiro.service.SecurityService;
import com.codeyunfei.shiro.tools.DigestsUtil;

import java.util.Map;

/**
 * @author 云飞
 * @create 2022-08-05-下午 04:07:52
 * @decription:
 */
public class SecurityServiceImpl implements SecurityService {
    /**
     * 权限服务层
     * @param loginName 登录名称
     * @return
     */
    @Override
    public Map<String,String> findPasswordByLoginName(String loginName) {
        return DigestsUtil.entryptPassword("123");
    }
}
