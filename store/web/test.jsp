<%--
  Created by IntelliJ IDEA.
  User: 王
  Date: 2017/11/7
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/jquery.js" type="text/javascript"></script>
<head>
    <title>测试页面</title>
</head>
<body>
<a id="test" href="#">点我</a>
<table id="table">

</table>
<div id="page"></div>
<script type="text/javascript">
    var jq = jQuery.noConflict();
    var property = "Category";
    jq.get("/store/testServlet","property="+property,testCall);

    function testCall(data) {
        var obj = eval(data);
        console.log(obj);
        var list = obj[0];
        var page = obj[1];
        for (var i=0 ; i <list.length ; i++) {
            jq("#table").append("<tr><td>"+list[i].categoryId+"</td><td>"+list[i].categoryName+"</td><td>"+new Date(list[i].createdate).Format('yyyy-MM-dd hh:mm:ss')+"</td><td>"+list[i].disable+"</td></tr>")
        }

        jq("#page").append(page.currentPage);
        jq("#page").append(page.totalCount);
        jq("#page").append(page.totalPage);
    }


    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
</script>

</body>
</html>
