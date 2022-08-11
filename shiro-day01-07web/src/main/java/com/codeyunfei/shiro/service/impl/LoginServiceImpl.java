package com.codeyunfei.shiro.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import com.codeyunfei.shiro.service.LoginService;

/**
 * @author 云飞
 * @create 2022-08-08-下午 03:21:59
 * @decription:
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(UsernamePasswordToken token) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (Exception e){
            return false;
        }
        return subject.isAuthenticated();
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
