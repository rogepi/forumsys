package com.controller;

import com.bean.Post;
import com.dao.IPostDAO;
import com.service.PostDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PostWrite")
public class PostWrite extends HttpServlet {
@Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String title = request.getParameter("title");
    HttpSession session = request.getSession();
    String author = (String) session.getAttribute("username_session");
    String type = request.getParameter("ntype");
    String content = request.getParameter("content");

    Post post = new Post();
    post.setTitle(title);
    post.setAuthor(author);
    post.setType(type);
    post.setContent(content);

    IPostDAO iPostDAO = new PostDAO();
    try {
      iPostDAO.create(post);
      response.sendRedirect("/my_news.jsp");
    } catch (Exception e) {
      e.printStackTrace();
      String info = "文章录入失败";
      request.setAttribute("outputMessage",info);
      response.sendRedirect("/info.jsp");
    }
}

@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);
  }
}
