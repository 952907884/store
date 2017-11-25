package cn.wang.store.web;

import cn.wang.store.entity.Category;
import cn.wang.store.entity.Page;
import cn.wang.store.entity.SubClasses;
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
            if (flag) {
                if (clazz == Category.class) {
                    sb.append("<tr> <td>大类编号</td>\n" +
                            " <td>大类名称</td>\n");
                } else if (clazz == SubClasses.class) {
                    sb.append("<tr><td>小类编号</td>\n" +
                            " <td>小类名称</td>\n");
                }
                sb.append("<td>状态</td><td>创建者</td><td>创建时间</td><td>修改者</td><td>修改时间</td></tr>");
                flag=false;
            }
            sb.append("<tr>");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String methodName = getGetter(field.getName());
                try {
                    Method method = clazz.getMethod(methodName);
                    Object obj = method.invoke(list.get(i));
                    sb.append("<td>"+obj+"</td>");
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            sb.append("</tr>");
        }
        this.getJspContext().getOut().write(sb.toString());

    }
}
