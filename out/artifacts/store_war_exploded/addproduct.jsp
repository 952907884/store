<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/7
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <link href="css/addProductStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <form id="myform" action="${pageContext.request.contextPath}/addProductServlet?name=opr" method="post" encType="multipart/form-data">
        <table cellspacing="10">
            <tr>
                <td>商品编号:</td>
                <td><input type="text" name="productId"> </td>
            </tr>
            <tr>
                <td>商品名称:</td>
                <td><input type="text" name="ProductName"> </td>
            </tr>
            <tr>
                <td>大类id:</td>
                <td><input type="text" name="categoryId"> </td>
            </tr>
            <tr>
                <td>小类id:</td>
                <td><input type="text" name="subclassID"> </td>
            </tr>
            <tr>
                <td>颜色id:</td>
                <td><input type="text" name="colourID"> </td>
            </tr>
            <tr>
                <td>sizeid:</td>
                <td><input type="text" name="尺码id"> </td>
            </tr>
            <tr>
                <td>年度:</td>
                <td><input type="text" name="year"> </td>
            </tr>
            <tr>
                <td>季节:</td>
                <td><input type="text" name="season"> </td>
            </tr>
            <tr>
                <td>成本:</td>
                <td><input type="text" name="costing"> </td>
            </tr>
            <tr>
                <td>系列id:</td>
                <td><input type="text" name="seriesid"> </td>
            </tr>
            <tr>
                <td>主题id:</td>
                <td><input type="text" name="themeid"> </td>
            </tr>
            <tr>
                <td>波段id:</td>
                <td><input type="text" name="ClothingbandID"> </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
<script src="js/jquery.js" type="text/javascript"></script>

</html>
