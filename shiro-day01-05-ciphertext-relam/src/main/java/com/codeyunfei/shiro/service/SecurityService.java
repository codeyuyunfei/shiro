package com.codeyunfei.shiro.service;

import java.util.Map;

/**
 * @author 云飞
 * @create 2022-08-05-下午 04:07:23
 * @decription: 权限服务接口
 */
public interface SecurityService {
    /**
     * 查找密码按用户登录名
     * @param loginName 登录名称
     * @return
     */
    Map<String,String> findPasswordByLoginName(String loginName);
}
