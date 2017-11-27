<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/25
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>菜单</title>
    <style>
        ul li{
            list-style: none;
        }
        ul li a{
            text-decoration: none;
        }
    </style>
</head>
<body>
    <c:if test="${empty sessionScope.user}">
    <h3><a href="login.jsp" target="main">你还没有登陆</a></h3>
    </c:if>
    <c:if test="${not empty sessionScope.user}">
        <h3>基础档案</h3>
        <ul>
            <li><a href="#">商品</a></li>
            <li><a href="${pageContext.request.contextPath}/servlet/showProperty?property=Category&pageNum=1" target="main">大类</a></li>
            <li><a href="${pageContext.request.contextPath}/servlet/showProperty?property=SubClasses&pageNum=1" target="main">小类</a></li>
            <li><a href="#">颜色</a></li>
            <li><a href="#">尺码</a></li>
            <li><a href="#">波段</a></li>
            <li><a href="#">主题</a></li>
            <li><a href="#">系列</a></li>
            <li><a href="#">年份</a></li>
            <li><a href="#">季节</a></li>
        </ul>
        <h3>系统设置</h3>
        <ul>
            <li><a href="uploadDatum.jsp" target="main">资料导入</a></li>
            <li><a href="login.jsp" target="main">登陆</a></li>
            <li><a href="logout.jsp" target="main">注销</a></li>
        </ul>
    </c:if>
</body>
</html>
