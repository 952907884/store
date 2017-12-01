package store.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;
import store.entity.Page;
import store.entity.PageMsg;
import store.service.ProductService;
import store.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.alibaba.fastjson.JSON.toJSONString;

/**
 * Created by 王 on 2017/11/7.
 * 显示商品类别
 */
@WebServlet("/servlet/showProperty")
public class showPropertyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String property=request.getParameter("property");   //获取用点击的表明
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        Page page = PageMsg.getPage(property);
        page.setPageNum(pageNum);
        page.setCurrentPage(currentPage);
        ProductService service = new ProductServiceImpl();
        page = service.showTest(page, property);
        JSONArray dataJsonArray = new JSONArray(page.getData());
        System.out.println(dataJsonArray);
        JSONObject pageJson = new JSONObject();
        pageJson.put(("pageNum"), page.getPageNum());
        pageJson.put("currentPage", page.getCurrentPage());
        pageJson.put("totalCount", page.getTotalCount());
        pageJson.put("totalPage", page.getTotalPage());
        JSONArray array = new JSONArray();
        array.add(dataJsonArray);
        array.add(pageJson);
        System.out.println(pageJson);
        //String jsonObject = JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd");
        PrintWriter out = response.getWriter();
        out.print(array);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
