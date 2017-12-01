package store.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 王 on 2017/11/7.
 */
@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;
        try{
            request=(HttpServletRequest)req;
            response=(HttpServletResponse)resp;
        }catch (ClassCastException e){
            throw new ServletException("non-HTTP request or response");
        }

        if("get".equalsIgnoreCase(request.getMethod())){
            request= new MyHttpRequestServlet(request);
        }else {
            request.setCharacterEncoding("UTF-8");
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

}
