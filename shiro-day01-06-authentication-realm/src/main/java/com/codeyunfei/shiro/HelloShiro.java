package com.codeyunfei.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author 云飞
 * @create 2022-08-05-下午 03:20:40
 * @decription:
 */
public class HelloShiro {
/*    @Test
    public void shiroLogin(){
        //1、导入ini配置创建工厂
        Factory<SecurityManager> factory= new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();
        //3、使用工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //4、使用工具获得subject主体
        Subject subject = SecurityUtils.getSubject();
        //5、构建账户密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jay", "123");
        //6、使用subject主体去登录
        subject.login(usernamePasswordToken);
        //7、打印登录信息
        System.out.println("是否登录成功："+subject.isAuthenticated());
    }*/

    @Test
    public void testPermissionRealm() {
        Subject subject = shiroLogin("jay", "123");
        //判断用户是否已经登录
        System.out.println("是否登录成功：" + subject.isAuthenticated());

        //---------检查当前用户的角色信息------------
        System.out.println("是否有管理员角色："+subject.hasRole("admin"));
        //---------如果当前用户有此角色，无返回值。若没有此权限，则抛 UnauthorizedException------------
        try {
            subject.checkRole("coder");
            System.out.println("有coder角色");
        }catch (Exception e){
            System.out.println("没有coder角色");
        }

        //---------检查当前用户的权限信息------------
        System.out.println("是否有查看订单列表资源："+subject.isPermitted("order:list"));
        //---------如果当前用户有此权限，无返回值。若没有此权限，则抛 UnauthorizedException------------
        try {
            subject.checkPermissions("order:add", "order:del");
            System.out.println("有添加和删除订单资源");
        }catch (Exception e){
            System.out.println("没有有添加和删除订单资源");
        }

    }


    /**
     * @Description 登录方法
     */
    private Subject shiroLogin(String loginName,String password) {
        //导入权限ini文件构建权限工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();
        //使用SecurityUtils工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //使用SecurityUtils工具获得主体
        Subject subject = SecurityUtils.getSubject();
        //构建账号token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginName, password);
        //登录操作
        subject.login(usernamePasswordToken);
        return subject;
    }
}
