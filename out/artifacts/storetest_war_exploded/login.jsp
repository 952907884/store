<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/26
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/servlet/login" method="post" target="_top">
        用户名：<input type="text" name="userAccount"><br>
        密&nbsp;码<input type="password" name = "password"><br>
        <input type="submit" value="登陆">
    </form>
</body>
</html>
