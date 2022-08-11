package com.codeyunfei.shiro.service;

import java.util.List;
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
    /**
     * @Description 查找角色按用户登录名
     * @param  loginName 登录名称
     * @return
     */
    List<String> findRoleByloginName(String loginName);

    /**
     * @Description 查找资源按用户登录名
     * @param  loginName 登录名称
     * @return
     */
    List<String>  findPermissionByloginName(String loginName);
}
