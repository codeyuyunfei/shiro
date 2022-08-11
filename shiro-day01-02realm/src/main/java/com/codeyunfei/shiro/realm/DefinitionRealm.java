package com.codeyunfei.shiro.realm;

import com.codeyunfei.shiro.service.SecurityService;
import com.codeyunfei.shiro.service.impl.SecurityServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author 云飞
 * @create 2022-08-05-下午 04:02:56
 * @decription: 声明自定义的realm
 */
public class DefinitionRealm extends AuthorizingRealm {
    /**
     * 认证
     * @param token 对象
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从AuthenticationToken中获得登录名称
        String loginName = (String) token.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        String password = securityService.findPasswordByLoginName(loginName);
        if ("".equals(password)||password==null){
            throw new UnknownAccountException("账户不存在");
        }
        //传递账号和密码
        return  new SimpleAuthenticationInfo(loginName,password,getName());
    }

    /**
     *@Description 鉴权
     *@param principals 令牌
     *@return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

}
