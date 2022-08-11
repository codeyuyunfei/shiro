package com.codeyunfei.shiro.service;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author 云飞
 * @create 2022-08-08-下午 03:20:29
 * @decription: 登录服务
 */
public interface LoginService {
    /**
     * @Description 登录方法
     * @param token 登录对象
     * @return
     */
    boolean login(UsernamePasswordToken token);

    /**
     * @Description 登出方法
     */
    void logout();
}
