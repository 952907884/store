package cn.train.web;

import cn.train.dao.TrainDao;
import cn.train.dao.impl.TrainDaoImpl;
import cn.train.entity.Train;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by 王 on 2017/11/27.
 */
@javax.servlet.annotation.WebServlet("/servlet/do_train")
public class TrainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        TrainDao dao = new TrainDaoImpl();
        String opr = request.getParameter("opr");
        if ("list".equals(opr)) {
            List<Train> trains = dao.getAllTrain();
            System.out.println(trains);
            request.setAttribute("trains",trains);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } else if ("del".equals(opr)) {
            String[] trainsId = request.getParameterValues("isDel");
            System.out.println(trainsId.length);
            int result = dao.delTrain(trainsId);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } else if ("find".equals(opr)) {
            String no = request.getParameter("train_no");
            Train train = dao.findTrain(no);
            request.getSession().setAttribute("train",train);
            response.sendRedirect("/train/train.jsp");
        } else if ("add".equals(opr)) {
            Train train =new Train();
            try {
                BeanUtils.populate(train, request.getParameterMap());
                int result = dao.addTrain(train);
                if (result > 0) {
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
