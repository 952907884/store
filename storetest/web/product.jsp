<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/28
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="http://mycompany.com" %>
<html>
<head>
    <title>商品列表</title>
    <style>
        div{
                float: left;
        }
    </style>
</head>
<body>
    <c:if test="${empty sessionScope.pages}">
        <jsp:forward page="/servlet/product?property=product&pageNum=1"/>
    </c:if>
    <c:if test="${not empty sessionScope.pages}">
        <c:forEach items="${sessionScope.pages.data}" var="p">
            <div>
                <img src="${myTag:pciPath(p.picpath)}">
                    ${p.subclassesid}
            </div>
        </c:forEach>
        <c:forEach begin="1" end="${sessionScope.pages.totalPage}" varStatus="p">
            <li><a href="${pageContext.request.contextPath}/servlet/product?property=product&pageNum=${p.index}">${p.index}</a></li>
        </c:forEach>

    </c:if>

</body>
</html>
