<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/25
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="http://mycompany.com" %>
<html>
<head>
    <title>商品属性</title>
</head>
<body>

    <c:if test="${empty requestScope.pages}">
        <%--<jsp:forward page="/servlet/showProperty"/>--%>
        <h2>没有属性</h2>
    </c:if>
    <c:if test="${not empty requestScope.pages}">
        <h2>逗逼了</h2>
        <table border="1" width="960px">
            <myTag:page property="${requestScope.pages}"/>
        </table>
        <myTag:pageNum page="${requestScope.pages}"/>
    </c:if>
</body>
</html>
