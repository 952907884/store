<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/12/1
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/addRole" method="post">
    角色名称：<input type="text" name="roleName"><br>
    角色资源：<input type="text" name="description"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
