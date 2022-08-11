package com.codeyunfei.shiro.service.impl;

import com.codeyunfei.shiro.service.SecurityService;

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
    public String findPasswordByLoginName(String loginName) {
        return "123";
    }
}
