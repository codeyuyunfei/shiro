package com.codeyunfei.shiro.realm;

import com.codeyunfei.shiro.service.SecurityService;
import com.codeyunfei.shiro.service.impl.SecurityServiceImpl;
import com.codeyunfei.shiro.tools.DigestsUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;
import java.util.Map;

/**
 * @author 云飞
 * @create 2022-08-05-下午 04:02:56
 * @decription: 声明自定义的realm
 */
public class DefinitionRealm extends AuthorizingRealm {

    /**
     * @Description 认证接口
     * @param token 传递登录token
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从AuthenticationToken中获得登录名称
        String loginName = (String) token.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        Map<String, String> map = securityService.findPasswordByLoginName(loginName);
        if (map.isEmpty()){
            throw new UnknownAccountException("账户不存在");
        }
        String salt = map.get("salt");
        String password = map.get("password");
        //传递账号和密码:参数1：用户认证凭证信息，参数2：明文密码，参数三：字节salt,参数4：当前DefinitionRealm名称
        return  new SimpleAuthenticationInfo(loginName,password, ByteSource.Util.bytes(salt),getName());
    }

    /**
     *@Description 鉴权
     *@param principals 令牌
     *@return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //拿到用户认证凭证信息
        String loginName = (String) principals.getPrimaryPrincipal();
        //从数据库中查询对应的角色和资源
        SecurityService securityService = new SecurityServiceImpl();
        List<String> roles = securityService.findRoleByloginName(loginName);
        List<String> permissions = securityService.findPermissionByloginName(loginName);
        //构建资源校验
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(permissions);
        return authorizationInfo;
    }

}
