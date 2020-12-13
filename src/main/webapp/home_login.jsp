<%--
  Created by IntelliJ IDEA.
  User: zzr11
  Date: 2020/12/9
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html lang="CN-zh">

<head>
  <meta charset="utf-8" />
  <meta name="author" content="rogepi" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/home_login.css">
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
    <h2>新闻发布系统 Design by
    <%=session.getAttribute("username_session")%>
    </h2>
    <button onclick="window.location.href='./index.html'">退出</button>

  </div>

  <br>

  <div class="footer">
    <p>版权所有.翻版必究 Copyright:@NewsSystem by rogepi</p>
  </div>

</body>