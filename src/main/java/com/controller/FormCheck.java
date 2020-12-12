package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formcheckservlet")
public class FormCheck extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    request.setCharacterEncoding("UTF-8");
    String userid = request.getParameter("userid");
    String userpwd = request.getParameter("userpwd");
    if (!"root".equals(userid)) {
      out.print("用户名不存在");
    } else {

      if ("".equals(userpwd)) {
        if (!"123".equals(userpwd)) {
          out.print("欢迎您" + userpwd);
        } else {
          out.print("密码错误" + userpwd);
        }
      }
    }
  }
}
