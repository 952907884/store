/**
 * Created by 王 on 2017/11/16.
 */
$(function () {
    $("#Series").click(function () {
        property=$(this).attr("id");
        $.get("/store/servlet/showProperty","property="+property,addPropertyConent);
    });



    function Series(data) {
        //$("#table-content").empty(); //清空表格内容
        var obj = eval(data);
        $("#table-content").empty();
        if(obj==null || obj == ""){
            alert("没有数据");
        }
        for (var i=0; i<obj.length ; i++) {
            console.log(obj[i].seriesName);
            var disable=obj[i].disable==1?"停用":"使用";
            var lastchange=obj[i].lastchange==undefined?"0":obj[i].lastchange;
            $("#table-content").append(
                "<tr><td><input type='checkbox' /></td>" +
                "<td class='am-text-center'>"+obj[i].seriesid+"</td><td><i style='margin-left:30px'>├─  </i><a href='#'>"+obj[i].seriesName+"</a></td>" +
                "<td>"+disable+"</td>" +
                "<td class='am-hide-sm-only'>"+obj[i].createdate+"</td>"+
                "<td class='am-hide-sm-only'>"+lastchange+"</td>"+
                "<td><div class='am-btn-toolbar'>"+
                "<div class='am-btn-group am-btn-group-xs'>"+
                "<a class='am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file' data-am-modal="+"\"{target: '#my-popups'}\""+"title='添加子栏目'></a>"+
                "<button class='am-btn am-btn-default am-btn-xs am-text-secondary am-round' data-am-modal="+"\"{target: '#my-popups'}\""+"title='修改'><span class='am-icon-pencil-square-o' ></span></button>"+
                " <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->"+
                "<button class='am-btn am-btn-default am-btn-xs am-text-warning  am-round'  title='复制'><span class='am-icon-copy'></span></button>"+
                "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-round'  title='删除'><span class='am-icon-trash-o'></span></button>"+
                "</div>"+
                "</div></td>"+
                "</tr>"
            )

        }
    }


    function addPropertyConent(data) {
        $("[encType='multipart/form-data']").remove();
        $("#form-nav").after(
            "<form id="+property+' class="am-form am-g" encType="multipart/form-data">'+
            '<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">'+
            '<thead>'+
            '<tr class="am-success">'+
            '<th class="table-check"><input type="checkbox" /></th>'+
            '<th class="table-id am-text-center">系列编号</th>'+
            '<th class="table-title">系列名称</th>'+
            '<th class="table-type">是否停用</th>'+
            '<th class="table-author am-hide-sm-only">创建日期</th>'+
            '<th class="table-date am-hide-sm-only">最后修改日期</th>'+
            '<th width="163px" class="table-set">操作</th>'+
            '</tr>'+
            '</thead>'+
            '<tbody id="table-content">'+

            '</tbody>'+
            '</table>'+
            '<div class="am-btn-group am-btn-group-xs">'+
            '<button type="button" class="am-btn am-btn-default" id="upload"><span class="am-icon-plus"></span>excel导入</button><input type="file" id="upfile" style="width: 85.5px;height: 24px">'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 上架</button>'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 下架</button>'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 移动</button>'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 移动</button>'+
            '<button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>'+
            '</div>'+
            '<ul class="am-pagination am-fr">'+
            '<li class="am-disabled"><a href="#">上一页</a></li>'+
            '<li><a href="#">下一页</a></li>'+
            '</ul>'+
            '<hr />'+
            '<p>'+
            '备注：操作图标含义'+
            '<a class="am-text-success am-icon-file" title="添加子栏目"> 添加子栏目</a>'+
            '<a class="am-icon-pencil-square-o am-text-secondary" title="修改"> 修改栏目</a>'+
            '<a class="am-icon-copy am-text-warning" title="复制"> 复制栏目</a>'+
            '<a class="am-icon-trash-o am-text-danger" title="删除"> 删除栏目</a>'+
            '</p>'+
            '</form>')

        Series(data);
    }
})