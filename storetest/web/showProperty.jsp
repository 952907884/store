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
    <c:if test="${empty sessionScope.pages}">
        <h2>没有属性</h2>
    </c:if>
    <c:if test="${not empty sessionScope.pages}">
        <table border="1" width="960px">
            <myTag:page property="${sessionScope.pages}"/>
        </table>
        <ul>
            <c:forEach begin="1" end="${sessionScope.pages.totalPage}" varStatus="p">
                <li><a href="${pageContext.request.contextPath}/servlet/showProperty?property=${property}&pageNum=${p.index}">${p.index}</a></li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
