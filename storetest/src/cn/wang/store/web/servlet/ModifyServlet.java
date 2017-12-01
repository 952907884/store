package cn.wang.store.web.servlet;

import cn.wang.store.entity.User;
import cn.wang.store.service.PropertyService;
import cn.wang.store.service.impl.PropertyServiceImple;
import cn.wang.store.util.FileClassNameUtil;
import cn.wang.store.util.JavaBeanUtil;
import cn.wang.store.util.SimpleData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 王 on 2017/11/29.
 */
@WebServlet(name = "ModifyServlet",value = "/servlet/modify")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String modifyDate = SimpleData.simpleDate(new Date());
        PropertyService service = new PropertyServiceImple();
        int result = -1;
        try {
            Class clazz = Class.forName(FileClassNameUtil.getClassName(request.getParameter("tableName")));
            String[] userName = new String[]{user.getUserName()};
            Map<String,String[]> map = new HashMap<>(request.getParameterMap());
            map.put("modifyBy",userName);
            map.put("modifyDate", new String[]{modifyDate});
            //System.out.println(JavaBeanUtil.populate(clazz, map));
            result = service.modify(JavaBeanUtil.populate(clazz, map));
            if (result > 0) {
                response.getWriter().write("修改成功");
            }else {
                response.getWriter().write("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
