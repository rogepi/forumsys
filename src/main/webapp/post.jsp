<%@ page import="com.dao.IPostDAO" %>
<%@ page import="com.service.PostDAO" %>
<%@ page import="com.bean.Post" %><%--
  Created by IntelliJ IDEA.
  User: zzr11
  Date: 2020/12/11
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>

<html lang="zh-CN">

<head>
  <meta charset="utf-8" />
  <meta name="author" content="rogepi" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/universal.css" />
  <link rel="stylesheet" href="css/about.css" />
  <link rel="stylesheet" href="css/post.css" />
  <title>CJ FORUM</title>
  <link rel="icon" href="images/rowlet.png" type="image/x-icon" />
</head>

<body>
<div class="header">
  <h1>CJ FORUM</h1>
  <p>Everything happens for a reason</p>
</div>

<div class="topnav">
  <ul>
    <li><a href="home.jsp">首页</a></li>
    <li><a href="mine.jsp">我的</a></li>
    <li><a href="publish.html">发帖</a></li>
    <li><a href="home_login.jsp">登录</a></li>
    <li><a href="about.html">关于</a></li>
  </ul>
</div>

<div class="row">
  <div class="card">
    <%
      int id = Integer.parseInt(request.getParameter("id"));
      IPostDAO iPostDAO = new PostDAO();
      Post post = new Post();
      post.setId(id);
      Post post1 = null;
      try {
        post1 = iPostDAO.findById(post);
      } catch (Exception e) {
        e.printStackTrace();
      }
      assert post1 != null;%>
    <h3><%=post1.getTitle()%></h3>
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
</div>

<div class="footer">
  <h2>Copyright:@Forumsys by rogepi</h2>
</div>

</body>

</html>
