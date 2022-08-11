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
     * @Description 查找用户密码
     * @param loginName 用户名称
     * @return 密码
     */
    Map<String,String> findPasswordByLoginName(String loginName);

    /**
     * @Description 查询角色
     * @param loginName 用户名
     * @return 角色字符串列表
     */
    List<String> findRoleByLoginName(String loginName);

    /**
     * @Description 查询资源
     * @param loginName 用户名
     * @return 资源字符串列表
     */
    List<String> findPermissionByLoginName(String loginName);
}
