package com.controller;

import com.bean.User;
import com.dao.IUserDAO;
import com.service.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignCheck")
public class SignCheck extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String username = request.getParameter("username");
    String userpwd = request.getParameter("userpwd");
    String reuserpwd = request.getParameter("reuserpwd");
    if (!userpwd.equals(reuserpwd)) {
      String info = "两次输入的密码不一致";
      request.setAttribute("outputMessage",info);
      response.sendRedirect("/info.jsp");
    }
    IUserDAO iUserDAO = new UserDAO();
    try {
      if (!iUserDAO.check(username)){
        String info = "用户名已存在";
        request.setAttribute("outputMessage",info);
        PrintWriter out = response.getWriter();
        out.print("<h1>hello</1>");
        response.sendRedirect("/info.jsp");
      } else {
        User user = new User();
        user.setName(username);
        user.setPasswd(userpwd);
        iUserDAO.create(user);
        response.sendRedirect("/index.html");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doPost(request,response);
  }


}

