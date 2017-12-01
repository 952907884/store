package cn.wang.store.web.servlet;

import cn.wang.store.entity.Page;
import cn.wang.store.service.PropertyService;
import cn.wang.store.service.impl.PropertyServiceImple;
import cn.wang.store.util.FileClassNameUtil;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 王 on 2017/11/25.
 */
@WebServlet("/servlet/showProperty")
public class ShowPropertyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNum = Integer.valueOf(request.getParameter("pageNum"));
        String property = request.getParameter("property");
        PropertyService service = new PropertyServiceImple();
        try {
            Class<T> clazz = (Class<T>) Class.forName(FileClassNameUtil.getClassName(property));
            Page<T> pages = service.showProperty(property, pageNum,clazz);
//            System.out.println(pages.getData());
            request.setAttribute("pages", pages);
            request.setAttribute("property",property);
            request.getRequestDispatcher("/showProperty.jsp").forward(request,response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
