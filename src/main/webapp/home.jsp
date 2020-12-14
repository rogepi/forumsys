<%@ page import="com.dao.IPostDAO" %>
<%@ page import="com.bean.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.service.PostDAO" %>

<%--
  Created by IntelliJ IDEA.
  User: zzr11
  Date: 2020/12/9
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html lang="zh-CN">

<head>
  <meta http-equiv="Expires" content="0">
  <meta http-equiv="kiben" content="no-cache">
  <meta charset="utf-8" />
  <meta name="author" content="rogepi" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/universal.css" />
  <link rel="stylesheet" href="css/home.css" />
  <title>CJ FORUM</title>
  <link rel="icon" href="images/rowlet.png" type="image/x-icon" />
  <link rel="shortcut icon" href="images/rowlet.png" type="image/x-icon" />
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
  <div class="leftcolumn">
    <div class="card">
      <h3>表白墙</h3>
      <br>
      <%
        IPostDAO iPostDAO = new PostDAO();
        List<Post> posts = null;
        try {
          posts = iPostDAO.findByType("表白墙");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./post.jsp" method="post" id="form<%=post.getId()%>">
        <label>
          <input type="text" name="id" value="<%=post.getId()%>">
        </label>
        <div class="posta"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
  </div>
  <div class="rightcolumn">
    <div class="card">
      <h3>学习讨论</h3>
      <br>
      <%
        try {
          posts = iPostDAO.findByType("学习讨论");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./post.jsp" method="post" id="form<%=post.getId()%>">
        <label>
          <input type="text" name="id" value="<%=post.getId()%>">
        </label>
        <div class="posta"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
    <div class="card">
      <h3>校园生活</h3>
      <br>
      <%
        try {
          posts = iPostDAO.findByType("校园生活");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./post.jsp" method="post" id="form<%=post.getId()%>">
        <label>
          <input type="text" name="id" value="<%=post.getId()%>">
        </label>
        <div class="posta"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
  </div>
</div>

<div class="footer">
  <h2>Copyright:@Forumsys by rogepi</h2>
</div>

</body>
