<%--
  Created by IntelliJ IDEA.
  User: zzr11
  Date: 2020/12/2
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Info</title>
</head>
<body>
<h1><%=request.getAttribute("outputMessage")%></h1>
<h1><%=session.getAttribute("session")%></h1>
<h1></h1>
</body>
</html>
