package com.controller;

import com.bean.User;
import com.dao.IUserDAO;
import com.service.UserDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String userName = request.getParameter("username");
    String userPwd = request.getParameter("userpwd");
    String info;
    User user = new User();
    user.setName(userName);
    user.setPasswd(userPwd);
    IUserDAO iUserDAO = new UserDAO();
    int i = 0;
    try {
      i = iUserDAO.check(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    HttpSession session = request.getSession();
    response.setContentType("text/html;charset=utf-8");
    switch (i) {
      case -1:
        info = "用户名不存在";
        //        out.print("<script>alert('username isn't
        // exit');window.history.back(-1);</script>");
        request.setAttribute("outputMessage", info);
        response.sendRedirect("/info.jsp");
        break;
      case 0:
        info = "密码不正确";
        //        out.print("<script>alert('password error');window.history.back(-1);</script>");
        request.setAttribute("outputMessage", info);
        response.sendRedirect("/info.jsp");
        break;
      case 1:
        info = "登录成功";
        session.setAttribute("username_session", userName);
        request.setAttribute("outputMessage", info);
        response.sendRedirect("/home.jsp");
        break;
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doPost(request, response);
  }
}
