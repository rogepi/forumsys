<%@ page import="com.dao.IPostDAO" %>
<%@ page import="com.bean.Post" %>
<%@ page import="java.util.List" %>
<%@ page import="com.service.PostDAO" %><%--
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
  <meta name="author" content="phpstudy" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="css/home.css">
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

  <div class="left">
    <div class="title">
      <p>时政要闻</p>
    </div>
    <%
      IPostDAO iPostDAO = new PostDAO();
      List<Post> posts = null;
      try {
        posts = iPostDAO.findByType("时政");
      } catch (Exception e) {
        e.printStackTrace();
      }
      assert posts != null;
      for (Post post : posts) { %>
    <form action="./new_show.jsp" method="post" id="form<%=post.getId()%>">
      <input style="display:none" type="text" name="id" value="<%=post.getId()%>">
      <div style="padding-top: 2%;padding-left: 3%;" class="lleft"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
    </form>
    <%
      }
    %>
  </div>


  <div class="right_top">
    <div class="title">
      <p>财经*国际</p>
    </div>
    <div class="rleft">
      <%
        try {
          posts = iPostDAO.findByType("财经");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./new_show.jsp" method="post" id="form<%=post.getId()%>">
        <input style="display:none" type="text" name="id" value="<%=post.getId()%>">
        <div style="padding-top: 2%;padding-left: 3%;" class="lleft"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
    <div class="rright">
      <%
        try {
          posts = iPostDAO.findByType("国际");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./new_show.jsp" method="post" id="form<%=post.getId()%>">
        <input style="display:none" type="text" name="id" value="<%=post.getId()%>">
        <div style="padding-top: 2%;padding-left: 3%;" class="lleft"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
  </div>
  <div class="right_bottom">
    <div class="title">
      <p>娱乐*体育</p>
    </div>
    <div class="rleft">
      <%
        try {
          posts = iPostDAO.findByType("娱乐");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./new_show.jsp" method="post" id="form<%=post.getId()%>">
        <input style="display:none" type="text" name="id" value="<%=post.getId()%>">
        <div style="padding-top: 2%;padding-left: 3%;" class="lleft"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
    <div class="rright">
      <%
        try {
          posts = iPostDAO.findByType("体育");
        } catch (Exception e) {
          e.printStackTrace();
        }
        assert posts != null;
        for (Post post : posts) { %>
      <form action="./new_show.jsp" method="post" id="form<%=post.getId()%>">
        <input style="display:none" type="text" name="id" value="<%=post.getId()%>">
        <div style="padding-top: 2%;padding-left: 3%;" class="lleft"><a href="" onclick="document.getElementById('form<%=post.getId()%>').submit();return false;"><%=post.getTitle()%></a></div>
      </form>
      <%
        }
      %>
    </div>
  </div>
</div>

<br>

<div class="footer">
  <p>版权所有.翻版必究 Copyright:@NewsSystem by rogepi</p>
</div>

</body>
