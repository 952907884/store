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
        .cl{
            clear: both;
        }
    </style>
</head>
<body>
    <c:if test="${empty sessionScope.pages}">
        <jsp:forward page="/servlet/product?property=Product&pageNum=1&currentPage=20"/>
    </c:if>
    <c:if test="${not empty sessionScope.pages}">
        <c:forEach items="${sessionScope.pages.data}" var="d">
            <div>
                <img src="${myTag:pciPath(d.map.picpath)}">
                    ${d.map.subClassesName}
            </div>
        </c:forEach>
        <div class="cl"></div>
        <ul>
            <c:forEach begin="1" end="${sessionScope.pages.totalPage}" varStatus="p">
                <li><a href="${pageContext.request.contextPath}/servlet/product?property=Product&currentPage=20&pageNum=${p.index}">${p.index}</a></li>
            </c:forEach>
        </ul>
    </c:if>

</body>
</html>
