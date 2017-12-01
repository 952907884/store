package cn.wang.store.web;

import cn.wang.store.entity.*;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by 王 on 2017/11/25.
 */
public class MyTag extends SimpleTagSupport {

    private Page<T> page;

    public void setProperty(Page page) {
        this.page = page;
    }

    private String getGetter(String field) {
        return "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    @Override
    public void doTag() throws JspException, IOException {
        StringBuffer sb = new StringBuffer();
        List list = page.getData();
        boolean flag = true;
        for (int i =0 ; i<list.size() ; i++){
            Class clazz = list.get(i).getClass();
            StringBuffer where = new StringBuffer();
            String clazzName = clazz.getName().substring(clazz.getName().lastIndexOf(".")+1);
            if (flag) {
                if (clazz == Category.class) {
                    sb.append("<tr> <td>大类编号</td>\n" +
                            " <td>大类名称</td>\n");
                } else if (clazz == SubClasses.class) {
                    sb.append("<tr><td>小类编号</td>\n" +
                            " <td>小类名称</td>\n");
                } else if (clazz == Band.class) {
                    sb.append("<tr><td>波段编号</td>\n" +
                            " <td>波段名称</td>\n");
                } else if (clazz == Color.class) {
                    sb.append("<tr><td>颜色编号</td>\n" +
                            " <td>颜色名称</td>\n");
                } else if (clazz == Size.class) {
                    sb.append("<tr><td>尺码编号</td>\n" +
                            " <td>尺码名称</td>\n");
                } else if (clazz == Theme.class) {
                    sb.append("<tr><td>主题编号</td>\n" +
                            " <td>主题名称</td>\n");
                } else if (clazz == Series.class) {
                    sb.append("<tr><td>系列编号</td>\n" +
                            " <td>系列名称</td>\n");
                }
                sb.append("<td>状态</td><td>创建者</td><td>创建时间</td><td>修改者</td><td>修改时间</td><td>操作</td></tr>");
                flag=false;
            }
            sb.append("<tr>");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String methodName = getGetter(field.getName());
                try {
                    Method method = clazz.getMethod(methodName);
                    Object obj = method.invoke(list.get(i));
                    where.append("&" + field.getName() + "=" + obj);
                    sb.append("<td>"+obj+"</td>");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            sb.append("<td><a href='/test/servlet/selectOne?tableName="+clazzName+where+"'>修改</a>&nbsp;<a href='#'>停用</a></td></tr>");
        }




        this.getJspContext().getOut().write(sb.toString());

    }
}
