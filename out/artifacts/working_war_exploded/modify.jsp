<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/27
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/workingServlet?opr=mod" method="post">
    <input type="hidden" name="id" value="${requestScope.working.id}"/><br>
    <input type="text" name = "title" value = "${requestScope.working.title}"/><br>
    <textarea width="45px" name="content">${requestScope.working.content}</textarea><br>
    <select name="type">
        <option value="1">技术</option>
        <option value="2">人事</option>
        <option value="3">行政</option>
    </select>
    <input type="submit" value="提交">
</form>
</body>
</html>
