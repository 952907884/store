<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/27
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>train信息</title>
</head>
<body>
    车次:${sessionScope.train.train_no}<br>
   发车——到达:${sessionScope.train.start_station}——${sessionScope.train.arrival_station}<br>
    发时——到时：${sessionScope.train.start_time}——${sessionScope.train.arrival_time}<br>
    车型：${sessionScope.train.type}<br>
    运行时间：${sessionScope.train.runtime}<br>
    里程：${sessionScope.train.runtime}<br>
</body>
</html>
