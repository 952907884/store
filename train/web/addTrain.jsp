<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/27
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班次</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/do_train?opr=add" method="post">
    车次:<input type="text" name="train_no"> <br>
    发车——到达:<input type="text" name="start_station">——<input type="text" name="arrival_station"><br>
    发时——到时：<input type="text" name="start_time">——<input type="text" name="arrival_time"><br>
    车型：<input type="text" name="type"><br>
    运行时间：<input type="text" name="runtime"><br>
    里程：<input type="text" name="mile"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
