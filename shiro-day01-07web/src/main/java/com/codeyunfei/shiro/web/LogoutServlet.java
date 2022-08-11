package com.codeyunfei.shiro.web;

import com.codeyunfei.shiro.service.LoginService;
import com.codeyunfei.shiro.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 云飞
 * @create 2022-08-08-下午 03:36:39
 * @decription: 登出
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        loginService.logout();
    }

}
