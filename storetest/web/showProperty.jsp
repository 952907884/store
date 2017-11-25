<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/25
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品属性</title>
</head>
<body>
    <c:if test="${empty sessionScope.pages}">
        没有属性
    </c:if>
    <c:if test="${not empty sessionScope.pages}">
        <table border="1" width="960px">
            <tr>
                <td>大类编号</td>
                <td>大类名称</td>
                <td>状体</td>
                <td>创建者</td>
                <td>创建时间</td>
                <td>修改者</td>
                <td>修改时间</td>
            </tr>
            <c:forEach items="${sessionScope.pages.data}" var="d">
                <tr>
                    <td>${d.subClassesId}</td>
                    <td>${d.subClassesName}</td>
                    <td>${d.status}</td>
                    <td>${d.createdBy}</td>
                    <td>${d.createDate}</td>
                    <td>${d.modifyBy}</td>
                    <td>${d.modifyDate}</td>
                </tr>
            </c:forEach>
        </table>
        <ul>
            <c:forEach begin="1" end="${sessionScope.pages.totalPage}" varStatus="p">
                <li><a href="/servlet/showProperty?property=${property}&pageNum=${p.index}">${p.index}</a></li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
