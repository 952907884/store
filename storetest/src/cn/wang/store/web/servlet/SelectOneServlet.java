package cn.wang.store.web.servlet;

import cn.wang.store.service.ProductService;
import cn.wang.store.service.impl.ProductServiceImpl;
import cn.wang.store.util.FileClassNameUtil;
import cn.wang.store.util.JavaBeanUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by 王 on 2017/11/29.
 */
@WebServlet(name = "SelectOneServlet",value = "/servlet/selectOne")
public class SelectOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tableName = request.getParameter("tableName");
        /*DateConverter converter = new DateConverter();
        converter.setPattern("yyyy-MM-dd HH:mm:ss");
        ConvertUtils.register(converter, Date.class);
        BeanUtils.populate(对象，request.getParameterMap());*/
        try {
            Object obj =  JavaBeanUtil.populate(Class.forName(FileClassNameUtil.getClassName(tableName)), request.getParameterMap());
            request.setAttribute("property", obj);
            request.getRequestDispatcher("/property.jsp").forward(request,response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
