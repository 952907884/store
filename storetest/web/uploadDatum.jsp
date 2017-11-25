<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/25
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资料上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/uploadDatumServlet" method="post" encType="multipart/form-data">
    <input type="file" name="datum">
    <input type="submit"/>
</form>
</body>
</html>
