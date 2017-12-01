package cn.wang.store.web.servlet;

import cn.wang.store.entity.Role;
import cn.wang.store.service.PrivilegeService;
import cn.wang.store.service.impl.PrivilegeServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by 王 on 2017/12/1.
 */
@WebServlet(name = "AddRoleServlet",value = "/servlet/addRole")
public class AddRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Role role = new Role();
        try {
            BeanUtils.populate(role,request.getParameterMap());
            PrivilegeService service = new PrivilegeServiceImpl();
            int result = service.addPrivelege(role);
            if (result > 0) {
                response.getWriter().write("添加成功");
            }else {
                response.getWriter().write("添加失败");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
