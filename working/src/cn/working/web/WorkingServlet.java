package cn.working.web;

import cn.working.dao.WorkingMapper;
import cn.working.entity.Working;
import cn.working.util.MybatisUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by 王 on 2017/11/24.
 */
@javax.servlet.annotation.WebServlet("/workingServlet")
public class WorkingServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        WorkingMapper workingMapper = sqlSession.getMapper(WorkingMapper.class);
        String opr = request.getParameter("opr");
        if ("list".equals(opr)) {
            List<Working> workingList = workingMapper.getAllWorking();
            request.getSession().setAttribute("workingList", workingList);
            response.sendRedirect("/working/index.jsp");
        }else if("check".equals(opr)){
            String id = request.getParameter("id");
            Working working = workingMapper.getWorking(Integer.parseInt(id));
            request.setAttribute("working", working);
            request.getRequestDispatcher("/working.jsp").forward(request, response);
        } else if ("del".equals(opr)) {
            String id = request.getParameter("id");
            System.out.print(id);
            int result = workingMapper.delWorking(Integer.parseInt(id));
            response.sendRedirect("/working/index.jsp");
        } else if ("modify".equals(opr)) {
            String id = request.getParameter("id");
            Working working = workingMapper.getWorking(Integer.parseInt(id));
            request.setAttribute("working", working);
            request.getRequestDispatcher("/modify.jsp").forward(request, response);
        } else if ("mod".equals(opr)) {
            Working working = new Working();
            try {
                BeanUtils.populate(working, request.getParameterMap());
                workingMapper.updateWorking(working);
                response.sendRedirect("/working/index.jsp");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
