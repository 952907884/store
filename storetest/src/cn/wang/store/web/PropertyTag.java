package cn.wang.store.web;

import cn.wang.store.entity.*;
import cn.wang.store.util.JavaBeanUtil;
import cn.wang.store.util.SimpleData;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * Created by 王 on 2017/11/30.
 */
public class PropertyTag extends SimpleTagSupport {
    private Object pro;

    public void setPro(Object pro) {
        this.pro = pro;
    }

    @Override
    public void doTag() throws JspException, IOException {
        boolean flag = true;
        Class clazz = pro.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String tableName = clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
        StringBuffer sb = new StringBuffer("<form action='/test/servlet/modify?tableName="+tableName+" method='post'><table>");
        String pName = "";
        String pID = "";
        String pnName = "";
        String pnID = "";
        String status = "状态";
        String createBy = "创建者";
        String createDate = "创建时间";
        String modifyBy = "修改者";
        String modifyDate = "修改时间";
        try {
        if (clazz == Category.class) {
            pName = "大类名称";
            pID = "大类编号";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("categoryId").getName()+" value="+clazz.getMethod("getCategoryId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getDeclaredField("categoryName").getName()+" value="+clazz.getMethod("getCategoryName").invoke(pro)+"></td></tr>");
        } else if (clazz == SubClasses.class) {
            pName = "小类名称";
            pID = "小类编号";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("subClassesId").getName()+" value="+clazz.getMethod("getSubClassesId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getDeclaredField("subClassesName").getName()+" value="+clazz.getMethod("getSubClassesName").invoke(pro)+"></td></tr>");
        } else if (clazz == Band.class) {
            pName = "波段名称";
            pID = "波段编号";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("bandId").getName()+" value="+clazz.getMethod("getBandId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getDeclaredField("bandName").getName()+" value="+clazz.getMethod("getBandName").invoke(pro)+"></td></tr>");
        } else if (clazz == Color.class) {
            pName = "颜色名称";
            pID = "颜色编号";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("colorId").getName()+" value="+clazz.getMethod("getColorId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getDeclaredField("colorName").getName()+" value="+clazz.getMethod("getColorName").invoke(pro)+"></td></tr>");
        } else if (clazz == Size.class) {
            pName = "尺码名称";
            pID = "尺码编号";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("sizeId").getName()+" value="+clazz.getMethod("getSizeId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getDeclaredField("sizeName").getName()+" value="+clazz.getMethod("getSizeName").invoke(pro)+"></td></tr>");
        } else if (clazz == Theme.class) {
            pName = "主题编号";
            pID = "主题名称";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("themeId").getName()+" value="+clazz.getMethod("getThemeId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getField("themeName").getName()+" value="+clazz.getMethod("getThemeName").invoke(pro)+"></td></tr>");
        } else if (clazz == Series.class) {
            pName = "系列编号";
            pID = "系列名称";
            sb.append("<tr><td>"+pName+"</td><td><input type='text' name="+clazz.getDeclaredField("seriesId").getName()+" value="+clazz.getMethod("getSeriesId").invoke(pro)+"></td></tr>");
            sb.append("<tr><td>"+pID+"</td><td><input type='text' name="+clazz.getDeclaredField("seriesName").getName()+" value="+clazz.getMethod("getSeriesName").invoke(pro)+"></td></tr>");
        }

            sb.append("<tr><td>"+status+"</td><td><input type='text' name="+clazz.getDeclaredField("status").getName()+" value='"+clazz.getMethod("getStatus").invoke(pro)+"'></td></tr>");
            sb.append("<tr><td>"+createBy+"</td><td><input type='text' name="+clazz.getDeclaredField("createdBy").getName()+" value='"+clazz.getMethod("getCreatedBy").invoke(pro)+"'></td></tr>");
            String createDateValue = clazz.getMethod("getCreateDate").invoke(pro)==null?null:SimpleData.simpleDate((Date)clazz.getMethod("getCreateDate").invoke(pro));
            sb.append("<tr><td>"+createDate+"</td><td><input type='text' name="+clazz.getDeclaredField("createDate").getName()+" value='"+ createDateValue+"'></td></tr>");
            sb.append("<tr><td>"+modifyBy+"</td><td><input type='text' name="+clazz.getDeclaredField("modifyBy").getName()+" value='"+clazz.getMethod("getModifyBy").invoke(pro)+"'></td></tr>");
            String modifyDateValue = clazz.getMethod("getModifyDate").invoke(pro)==null?null:SimpleData.simpleDate((Date)clazz.getMethod("getModifyDate").invoke(pro));
            sb.append("<tr><td>"+modifyDate+"</td><td><input type='text' name="+clazz.getDeclaredField("modifyDate").getName()+" value='"+modifyDateValue+"'></td></tr>");
            sb.append("<tr><td><input type='submit' value='提交'/></td></tr></table></form>");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        this.getJspContext().getOut().write(sb.toString());
    }
}
