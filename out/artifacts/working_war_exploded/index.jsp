<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/24
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>working</title>
  </head>
  <body>
    <c:if test="${empty sessionScope.workingList}">
      <c:redirect url="/workingServlet?opr=list"/>
    </c:if>

  <c:if test="${not empty sessionScope.workingList}">
      <table border="1" width="800px">
        <tr>
          <td>笔记标题</td>
          <td>笔记分类</td>
          <td>编写时间</td>
          <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.workingList}" var="working">
          <tr>
            <td>${working.title}</td>
            <c:choose>
              <c:when test="${working.type eq 1}">
                <td>技术</td>
              </c:when>
              <c:when test="${working.type eq 2}"><td>人事</td></c:when>
              <c:otherwise><td>行政</td></c:otherwise>
            </c:choose>
            <td>${working.date}</td>
            <td><a href="${pageContext.request.contextPath}/workingServlet?opr=check&id=${working.id}">查看</a>&nbsp;<a href="${pageContext.request.contextPath}/workingServlet?opr=del&id=${working.id}">删除</a>&nbsp;<a href="${pageContext.request.contextPath}/workingServlet?opr=modify&id=${working.id}">修改</a></td>
          </tr>
        </c:forEach>
      </table>
  </c:if>
  </body>
</html>
