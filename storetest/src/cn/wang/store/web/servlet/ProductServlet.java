package cn.wang.store.web.servlet;

import cn.wang.store.entity.Page;
import cn.wang.store.service.ProductService;
import cn.wang.store.service.impl.ProductServiceImpl;
import cn.wang.store.util.FileClassNameUtil;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 王 on 2017/11/28.
 */
@WebServlet(value = "/servlet/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String property = request.getParameter("property");
        String pageNum = request.getParameter("pageNum");
        ProductService service = new ProductServiceImpl();
        String path = this.getServletContext().getRealPath("");
        try {
            Class<T> clazz = (Class<T>) Class.forName(FileClassNameUtil.getClassName(property));
            Page<T> page  = service.findAllProduct(property, Integer.parseInt(pageNum), clazz);
            request.getSession().setAttribute("pages", page);
            response.sendRedirect("/test/product.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
