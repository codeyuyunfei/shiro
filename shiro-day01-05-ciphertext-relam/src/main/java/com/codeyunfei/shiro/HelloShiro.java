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
    @Test
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
    }
}
