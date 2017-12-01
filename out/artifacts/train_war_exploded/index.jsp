<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/27
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>火车班次</title>
  </head>
  <body>

    <a href="${pageContext.request.contextPath}/addTrain.jsp">添加班次</a>
    <c:if test="${empty requestScope.trains}">
      <c:redirect url="/servlet/do_train?opr=list"/>
    </c:if>
    <c:if test="${not empty requestScope.trains}">
      <form action="${pageContext.request.contextPath}/servlet/do_train?opr=del" method="post">
        <table border="1">
          <tr>
            <td><input type="submit" value="删除"></td>
            <td>车次</td>
            <td>发车——到达</td>
            <td>发时——到时</td>
            <td>车型</td>
            <td>运行时间</td>
          </tr>
          <c:forEach items="${requestScope.trains}" var="t">
            <tr>
              <td><input type="checkbox" name="isDel" value="${t.train_no}"></td>
              <td><a href="${pageContext.request.contextPath}/servlet/do_train?opr=find&train_no=${t.train_no}"> ${t.train_no}</a></td>
              <td>${t.start_station}——${t.arrival_station}</td>
              <td>${t.start_time}——${t.arrival_time}</td>
              <td>${t.type}</td>
              <td>${t.runtime}</td>
            </tr>
          </c:forEach>
        </table>
      </form>
    </c:if>
  </body>
</html>
