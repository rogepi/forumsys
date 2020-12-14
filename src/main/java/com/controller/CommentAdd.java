package com.controller;

import com.bean.Comment;
import com.dao.iCommentDAO;
import com.service.CommentDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CommentAdd")
public class CommentAdd extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    request.setCharacterEncoding("UTF-8");
    int post_id = Integer.parseInt(request.getParameter("post_id").toString().trim());
    HttpSession session = request.getSession();
    String author = (String) session.getAttribute("username_session");
    String content = request.getParameter("content");

    Comment comment = new Comment();
    comment.setPost_id(post_id);
    comment.setAuthor(author);
    comment.setContent(content);

    iCommentDAO iCommentDAO = new  CommentDAO();
    try {
      iCommentDAO.create(comment);
      response
          .getWriter()
          .print(
              "<script type=\"text/javascript\">\n"
                  + "window.location.href='post.jsp?id="+post_id +"'\n"
                  + "</script>");
//      response.sendRedirect("/mine.jsp");
    } catch (Exception e) {
      e.printStackTrace();
      String info = "评论失败失败";
      request.setAttribute("outputMessage",info);
      response.sendRedirect("/info.jsp");
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doPost(request,response);
  }
}
