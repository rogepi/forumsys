<%--
  Created by IntelliJ IDEA.
  User: rogepi
  Date: 2020/12/8
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="author" content="rogepi">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="img/rowlet.png" type="image/x-icon" />
  <script src="js/jquery-3.5.1.min.js"></script>
  <script src="js/ajax.js"></script>
  <script src="js/script.js"></script>
  <title>Rogepi – Get smarter about what matters to you.</title>
</head>
<body>
  <form action="">
    用户名称：<input type="text" name="userid" id="userid" onblur="formcheck()"><br>
    用户密码: <input type="password" name="userpwd" id="userpwd"><br>
    <input type="button" value="登录" onclick="formcheck()"/>
    <div id="result"></div>
  </form>
</body>
</html>
