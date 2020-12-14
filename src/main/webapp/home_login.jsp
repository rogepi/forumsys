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
  <meta charset="utf-8" />
  <meta name="author" content="rogepi" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/universal.css" />
  <link rel="stylesheet" href="css/about.css" />
  <link rel="stylesheet" href="css/home_login.css" />
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
    <h3>当前登录</h3>
    <br>
    <h2><%=session.getAttribute("username_session")%>, 欢迎您</h2>
    <button onclick="window.location.href='./index.html'">登出</button>
  </div>
</div>

<div class="footer">
  <h2>Copyright:@Forumsys by rogepi</h2>
</div>

</body>

</html>