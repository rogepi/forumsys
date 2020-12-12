<%@ page import="com.dao.IPostDAO" %>
<%@ page import="com.service.PostDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Post" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zzr11
  Date: 2020/12/12
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html lang="CN-zh">

<head>
  <meta charset="utf-8"/>
  <meta name="author" content="phpstudy"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <link rel="stylesheet" href="css/my_news.css">
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
    String author = (String) session.getAttribute("username_session");
    IPostDAO iPostDAO = new PostDAO();
    List<Post> posts = null;
    try {
      posts = iPostDAO.findByAuthor(author);
    } catch (Exception e) {
      e.printStackTrace();
    }
    assert posts != null;
    for (Post post : posts) { %>
      <form action="./new_show.jsp" method="post" id="form<%=post.getId()%>">
      <input type="text" name="id" value="<%=post.getId()%>">
      <div class="lleft"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
  <%
    }
  %>

</div>

<br>

<div class="footer">
  <p>版权所有.翻版必究 Copyright:@NewsSystem by Me</p>
</div>
</body>
</html>
