package com.codeyunfei.shiro.web;

import com.codeyunfei.shiro.service.LoginService;
import com.codeyunfei.shiro.service.impl.LoginServiceImpl;
import org.apache.shiro.authc.UsernamePasswordToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 云飞
 * @create 2022-08-08-下午 03:35:58
 * @decription: 登录方法
 */

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //获取输入的帐号密码
        String username = req.getParameter("loginName");
        String password = req.getParameter("password");
        //封装用户数据，成为Shiro能认识的token标识
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        LoginService loginService = new LoginServiceImpl();
        //将封装用户信息的token进行验证
        boolean isLoginSuccess = loginService.login(token);
        if (!isLoginSuccess) {
            //重定向到未登录成功页面
            resp.sendRedirect("login.jsp");
            return;
        }
        req.getRequestDispatcher("/home").forward(req, resp);
    }

}
