<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/12/1
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加权限</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/addPrivilege" method="post">

    权限名称：<input type="text" name="priName"><br>
    权限资源：<input type="text" name="resource"><br>
    权限描述：<input type="text" name="description"><br>
    权限后缀：<input type="text" name="stuffix"><br>
    权限参数：<input type="text" name="params"><br>
    权限类型：<input type="text" name="Type"><br>
    权限状态：<input type="text" name="status"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
