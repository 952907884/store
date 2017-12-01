<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/27
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>笔记</title>
</head>
<body>
    <h3>我的工作笔记</h3>
标题：${requestScope.working.title}
内容：${requestScope.working.content}
类别：<c:choose>
        <c:when test="${requestScope.working.type eq 1}">
            技术
        </c:when>
        <c:when test="${requestScope.working.type eq 2}">
            人事
        </c:when>
        <c:otherwise>行政</c:otherwise>
    </c:choose>
日期: ${requestScope.working.date}
</body>
</html>
