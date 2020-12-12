<%@ page import="com.dao.IUserDAO" %>
<%@ page import="com.dao.IPostDAO" %>
<%@ page import="com.service.PostDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Post" %><%--
  Created by IntelliJ IDEA.
  User: zzr11
  Date: 2020/12/11
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<html lang="CN-zh">

<head>
  <meta charset="utf-8" />
  <meta name="author" content="phpstudy" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/new_show.css">
  <title>新闻发布系统</title>
</head>
<body>
<div class="header">
  <div class="nav">
    <ul>
      <li><a href="./home.jsp">首页</a></li>
      <li><a href="./my_news.jsp">我的文章</a></li>
      <li><a href="./new_edit.html">发布文章</a></li>
      <li><a href="./home_login.jsp">登录</a></li>
      <li><a href="./about.html">关于我们</a></li>
    </ul>
  </div>
</div>

<br>

<div class="main">
  <%
    int id = Integer.parseInt(request.getParameter("id"));
    IPostDAO iPostDAO = new PostDAO();
    Post post = new Post();
    post.setId(id);
    Post post1 = iPostDAO.findById(post);
  %>
  <div class="title">
    <p><%=post1.getTitle()%></p>
  </div>
  <div class="ifmt">
    <div class="author">
      <p>作者：<%=post1.getAuthor()%></p>
    </div>
    <div class="type">
      <p>类型：<%=post1.getType()%></p>
    </div>
    <div class="date">
      <p>时间：<%=post1.getDate()%></p>
    </div>
  </div>
  <div class="content">
    <%=post1.getContent()%>
  </div>

</div>

<br>

<div class="footer">
  <p>版权所有.翻版必究 Copyright:@NewsSystem by Me</p>
</div>

</body>
</html>
